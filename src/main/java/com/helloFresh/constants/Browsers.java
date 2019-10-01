package com.helloFresh.constants;


public enum Browsers {

	CHROME("chrome"),
	FIREFOX ( "firefox"),
	SAFARI ( "safari"),
	OPERA ( "opera"),
	INTERNET_EXPLORER ( "ie"),
	HTML_UNIT ( "htmlunit");

	private final String browserType;

	private Browsers(String browserType) {
		this.browserType=browserType;
	}

	public String getBrowserType()
	{
		return this.browserType;
	}

	public static Browsers getValue(String browser)
	{
		for(Browsers browserType:values())
		{
			if(browserType.getBrowserType().equals(browser))
				return browserType;
		}
		throw new IllegalArgumentException(browser + " is not a valid browser");
	}

	public static void main(String[] args) {
		System.out.println(		Browsers.getValue("chrome"));
	}
}
