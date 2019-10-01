package com.helloFresh.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import com.helloFresh.constants.Environment;

public class ConfigProperties
{
	private static String environment=null;
	static Properties prop =null;
	public static String fileName="Config.properties";
	private static final String pathAppender = "/com/helloFresh/config/";
	

	public ConfigProperties(Environment env,String fName) 
	{
		environment = env.getenvironmentType();
		if(fName!=null && fName.length()>0)
			fileName=fName;
		InputStream inputStream = null;
		try
		{
			prop = new Properties();
			inputStream = this.getClass().getResourceAsStream(pathAppender+ environment+File.separator+fileName);
			prop.load(inputStream);
		}
		catch(Exception e)
		{
			System.out.println("Exception: " + e);
		}
		finally
		{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public ConfigProperties(Environment env) 
	{
		
		environment = env.getenvironmentType();
		InputStream inputStream = null;
		try
		{
			prop = new Properties();
			inputStream = this.getClass().getResourceAsStream(pathAppender+ environment+File.separator+fileName);
			prop.load(inputStream);
		}
		catch(Exception e)
		{
			System.out.println("Exception: " + e);
		}
		finally
		{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String fetchConfig(String property) 
	{
		String	result = prop.getProperty(property);
		return result;
	}
	
	
	public Map<String, String> getMapOfConfigFile()
	{
		
		Map<String, String> map = new HashMap<String,String>();
		map.putAll(prop.entrySet()
				.stream()
				.collect(Collectors.toMap(e -> e.getKey().toString(), 
						e -> e.getValue().toString())));
		return map;
	}
	
}
