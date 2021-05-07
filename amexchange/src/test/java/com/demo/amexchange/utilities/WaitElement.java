package com.demo.amexchange.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitElement {
	
public WebDriver driver; 
	
	public WaitElement(WebDriver driver) {
		this.driver = driver;
	}
	
	public void WaitForElement(WebElement element,long timeoutinsec)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeoutinsec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
