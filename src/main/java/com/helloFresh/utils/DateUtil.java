package com.helloFresh.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static String getTimeStamp()
	{
		return String.valueOf(new Date().getTime());
	}

	
	public static String getCurrentDate(String format)
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(cal.getTime()).toString();
	}
	
	
}
