package com.helloFresh.cache;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.helloFresh.cache.ProductYAMLMapping.ProductInfo.ProductDetails;
import com.helloFresh.constants.Environment;

public class ProductCache {
	
	static ProductYAMLMapping cachePROD;
	static ProductYAMLMapping cacheQA;
	private static final String pathAppender = "src/main/resources/com/helloFresh/config/";
	private static ProductYAMLMapping getInstance(Environment env)
	{
		if(Environment.PROD.equals(env))
		{
			if(cachePROD==null)
			{
				ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
				try {
					cachePROD=mapper.readValue(new File(pathAppender+ env.getenvironmentType()+"/ProductDetails.yaml"), ProductYAMLMapping.class);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return cachePROD;
		}
		else if(Environment.QA.equals(env))
		{
			if(cacheQA==null)
			{
				ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
				try {
					cacheQA=mapper.readValue(new File(pathAppender+ env.getenvironmentType()+"/ProductDetails.yaml"), ProductYAMLMapping.class);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return cacheQA;
		}
		return null;
	}

	private ProductCache() {
		// TODO Auto-generated constructor stub
	}

	public static Map<String, ProductDetails> getProductMapping(Environment env)
	{
		ProductYAMLMapping cache=getInstance(env);
		return cache.getProductDetails().getProduct();
	}

	public static ProductDetails getProductDetails(Environment env,String ProductName)
	{
		ProductYAMLMapping cache=getInstance(env);
		return cache.getProductDetails().getProduct().get(ProductName);
	}

	public static List<String> getProductList(Environment env)
	{
		ProductYAMLMapping cache=getInstance(env);
		return		cache.getProductDetails().getProduct().entrySet().stream().map(x-> x.getKey()).collect(Collectors.toList());
	}

}
