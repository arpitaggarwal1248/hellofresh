package com.helloFresh.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

	public static int generateRandomNumber(int minIndex,int maxIndex)
	{
		return ThreadLocalRandom.current().nextInt(minIndex,maxIndex);
	}

	public static String generateRandomEmailId() {
		return "hf_challenge_"+DateUtil.getCurrentDate("ddHHmmss")+"@hf.com";
	}

	public static String generateRandomMobileNumber()
	{
		return String.valueOf((long)(Math.random()*1000000 + 9999000000L));
	}

	public static String generateRandomName()
	{
		int len=RandomUtil.generateRandomNumber(5, 10);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<len;i++)
		{
			int num=RandomUtil.generateRandomNumber(97, 122);
			sb.append((char)num);
		}	
		return sb.toString();
	}

}
