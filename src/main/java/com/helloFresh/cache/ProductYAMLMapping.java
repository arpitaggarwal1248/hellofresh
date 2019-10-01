package com.helloFresh.cache;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductYAMLMapping {

	@JsonProperty("product_details")
	ProductInfo productDetails;

	public ProductInfo getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductInfo productDetails) {
		this.productDetails = productDetails;
	}

	public static class ProductInfo{

		@JsonAnySetter
		Map<String,ProductDetails> product=new HashMap<String,ProductDetails>();



		public Map<String, ProductDetails> getProduct() {
			return product;
		}



		public void setProduct(Map<String, ProductDetails> product) {
			this.product = product;
		}

		public static class ProductDetails
		{
			String testCaseName;
			String productName;
			String price;

			public String getTestCaseName() {
				return testCaseName;
			}
			public void setTestCaseName(String testCaseName) {
				this.testCaseName = testCaseName;
			}
			public String getProductName() {
				return productName;
			}
			public void setProductName(String productName) {
				this.productName = productName;
			}
			public String getPrice() {
				return price;
			}
			public void setPrice(String price) {
				this.price = price;
			}


		}
	}


}
