package com.helloFresh.constants;

public enum Environment {
	
	PROD ( "prod"),
	QA ( "qa");
	
	private final String environmentType;

	private Environment(String environmentType) {
		this.environmentType=environmentType;
	}

	public String getenvironmentType()
	{
		return this.environmentType;
	}

	public static Environment getValue(String Environment)
	{
		for(Environment environmentType:values())
		{
			if(environmentType.getenvironmentType().equalsIgnoreCase(Environment))
				return environmentType;
		}
		throw new IllegalArgumentException(Environment + " is not a valid Environment");
	}

}
