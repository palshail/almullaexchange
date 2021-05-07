package com.demo.amexchange.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("message is + " +e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String Username()
	{
		String name = pro.getProperty("UserName");
		return name;
	}
	public String Password()
	{
		String password = pro.getProperty("Password");
		return password;
	}
	public String Driverpathchrome()
	{
		String path = pro.getProperty("winchromedriver");
		return path;
	}
	public String Macchrome()
	{
		String path = pro.getProperty("macchromedriver");
		return path;
	}
	public String Firefoxbrowser()
	{
		String path = pro.getProperty("Firefoxdriver");
		return path;
	}
	public String getBrowser()
	{
		String path = pro.getProperty("browser");
		return path;
	}

}
