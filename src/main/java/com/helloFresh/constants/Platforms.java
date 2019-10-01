package com.helloFresh.constants;

public enum Platforms {

	WINDOWS ( "windows"),
	ANDROID ( "android"),
	MAC ( "mac"),
	UNIX ( "unix");

	private final String platformType;

	private Platforms(String platformType) {
		this.platformType=platformType;
	}

	public String getPlatformType()
	{
		return this.platformType;
	}

	public static String getValue(String platform)
	{
		for(Platforms platformType:values())
		{
			if(platformType.getPlatformType().equals(platform))
				return platform;
		}
		throw new IllegalArgumentException(platform + " is not a valid platform");
	}

	public static Platforms getCurrentPlatform()
	{
		String osName=System.getProperty("os.name").toLowerCase();

		if(osName.indexOf("mac")>=0)
			return MAC;
		
		if(osName.indexOf("win")>=0)
			return WINDOWS;
		if(osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0)
			return UNIX;
		return  null;
	}

}
