package com.helloFresh.cache;

import com.helloFresh.constants.Environment;

public class CommonCache {

	private static Environment env=Environment.PROD;

	public static Environment getEnv() {
		return env;
	}

	public static void setEnv(Environment environment) {
		env = environment;
	}

	public static void setEnv()
	{
		try {
			if(System.getProperty("env")!=null)
				env=Environment.getValue(System.getProperty("env"));
		}
		catch (Exception e) {
		}
	}



}
