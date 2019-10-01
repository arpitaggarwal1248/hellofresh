package com.helloFresh.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.helloFresh.reporting.ExtentTestManager;

public class Log {



	public static boolean printconsoleoutput; 

	static {

		try { Properties props = new Properties(); InputStream cpr =
				Log.class.getResourceAsStream("/log4j.properties"); props.load(cpr);
				PropertyConfigurator.configure(props); }
		catch (IOException e) {
			e.printStackTrace(); }
	} // static block


	public static Logger lsLog4j() { return
			Logger.getLogger(Thread.currentThread().getName()); }

	public static String callerClass() { return new
			Exception().getStackTrace()[1].getClassName(); }

	public static void message(String description) { 
		Reporter.log(description);
		lsLog4j().log(callerClass(), Level.INFO, description, null); 
		try {
			ExtentTestManager.getTest().log(Status.INFO, description);	
		} catch (Exception e) {
		}

	}


	public static void exception(Exception e,WebDriver driver) throws Exception { 
		try {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String path = new Screenshot(driver).capture();
			ExtentTestManager.getTest().log(Status.FAIL, sw.toString());	
			ExtentTestManager.getTest().log(Status.FAIL, "<font color=\"red\"> Snapshot: " + getBase64Source(path)+ "</font>");
		} catch (Exception exception) {
		}
		throw e;
	}

	public static String getBase64Source(String imgSrc) {
		return "<a href='" + imgSrc + "' data-featherlight='image'><img class='report-img'  ' width='30%'" +
				"src='" + imgSrc + "' /></a>";
	}

}
