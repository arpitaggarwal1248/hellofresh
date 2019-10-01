package com.helloFresh.utils;


import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class Screenshot {
	
	private WebDriver driver;	
	private final String folderPath = "test-output/";
		
	public Screenshot(WebDriver driver) {		
		this.driver = driver;
	//	validateFolderExists();
	}
	
	
	@SuppressWarnings("unused")
	private void validateFolderExists() {
		
		File folder = new File(System.getProperty("user.dir")+File.separator+folderPath);
		if (!folder.exists())
			folder.mkdir();
	}
		
	/*
	 * public String capture(String fileName) { String name=null; try { name =
	 * System.getProperty("user.dir")+File.separator+folderPath + fileName + ".png";
	 * FileOutputStream file = new FileOutputStream(name); file.write(
	 * ((TakesScreenshot) driver) .getScreenshotAs(OutputType.BYTES)); file.close();
	 * } catch (Exception ex) { throw new
	 * RuntimeException("cannot create screenshot;", ex); } return name;
	 * 
	 * }
	 */
	public String capture() {		
		return "data:image/jpg;base64, "+ ((TakesScreenshot) driver)
		.getScreenshotAs(OutputType.BASE64);
	        
	}
}
