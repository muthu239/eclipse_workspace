package com.utils;

import java.util.Date;


/*
 * creating DateUtils class
 */
public class DateUtils
{
	public static String getTimeStamp()
	{
		Date date=null;
		try
		{
			date = new Date();
		}
		catch(Exception e)
        {
            System.out.println(e);
        }
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
