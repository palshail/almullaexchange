package com.demo.amexchange.stepdefination;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.amexchange.pageObject.LoginScnarioObject;
import com.demo.amexchange.utilities.ReadConfig;
import com.demo.amexchange.utilities.WaitElement;
 

public class BaseClass {

	
	ReadConfig rc = new ReadConfig();
	public String baseURL = rc.getApplicationURL();
	public String UserName = rc.Username();
	public String Password = rc.Password();
	public static WebDriver driver;
	public static Logger log;
	public static WaitElement wait;
	
	public void setup(String br)
	{
		log = Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("log4J.properties");
		br = rc.getBrowser();
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rc.Driverpathchrome());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			log.info("Chrome Open succsfully");
		}
		else if(br.equals("macchrome"))
		{
			System.setProperty("webdriver.chrome.driver", rc.Macchrome());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			log.info("macchrome Open");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.Firefoxbrowser());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			log.info("FireFox Open");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		log.info("Base URL Open");
	}
	
	public void quit()
	{
		driver.quit();
		log.info("execution completed");
	}
	
	public void capturescreenshot(WebDriver driver, String tsname)throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File source = ts.getScreenshotAs(OutputType.FILE);
		File taget = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tsname + ".png");
		FileUtils.copyFile(source, taget);
		System.out.println("Screeb shot captured");	
	}
	
}
