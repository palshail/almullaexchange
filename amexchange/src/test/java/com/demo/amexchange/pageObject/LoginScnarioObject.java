package com.demo.amexchange.pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.demo.amexchange.stepdefination.BaseClass;
import com.demo.amexchange.utilities.WaitElement;

public class LoginScnarioObject extends BaseClass {
	
	WebDriver ldriver;
	
	public LoginScnarioObject(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="civil-id") @CacheLookup WebElement civilid;
	@FindBy(id="password") @CacheLookup WebElement civilpassword;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[2]/div/div/div[3]/button[1]") @CacheLookup WebElement btnlogin;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div") WebElement closeinvite;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[1]") WebElement closeinviteclick;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[1]/a[1]/span[2]") WebElement Remittancetab;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[1]/a[2]/span[2]") WebElement MyTransactionstab;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[1]/a[3]/span[2]") WebElement Beneficiariestab;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[1]/a[4]/span[2]") WebElement ExchangeRatetab;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[1]/a[5]/span[2]") WebElement DeliverFXtab;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[1]/div[2]/span") WebElement lastvisittab;
	
	

	
	public void setusermane(String username)
	{
		wait = new WaitElement(ldriver);
		wait.WaitForElement(civilid, 60);
		civilid.clear();
		civilid.sendKeys(username);
	}
	public void setpassword(String password)
	{
		wait.WaitForElement(civilpassword, 60);
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("document.getElementById('password').value = 'password';");
		civilpassword.sendKeys(password);
	}
	public void clicklogin()
	{
		wait.WaitForElement(btnlogin, 60);
		btnlogin.click();
		log.info("Login Buttion Click");
	
	}
	
	public void closeinvite() throws IOException
	{
		 wait.WaitForElement(closeinvite, 60);
		 String Title = closeinvite.getText();
		 String invitetxt = Title.substring(2, 17);
		 System.out.println(invitetxt);
		 if(invitetxt.equals("INVITE A FRIEND"))
		 {
		 Assert.assertTrue(true); 
		 log.info("Login test PASS"); 
		 }else{
		 capturescreenshot(driver, "testlogin"); 
		 Assert.assertTrue(false);
		 log.info("Login test FAIL SS attached");
		 }
		 
		 closeinviteclick.click();
		 log.info("Invite popup close success");
		
	}
	
	public Boolean verifyelement()
	{
	Boolean bl;
	if(MyTransactionstab.isDisplayed())
	{
		bl = true;
	}else {
		bl = false;
	}
	return bl;
	}
	

	public void verifytabelastvsit()
	{
		wait.WaitForElement(Remittancetab, 60);
		
		if(Remittancetab.getText().equals("Remittance"))
		{
			 log.info("Remittance is present"); 
			 System.out.println(Remittancetab.getText());
		}else
		{
			log.info("Remittance is notpresent SS attached");
		}
		
		System.out.println(verifyelement());

		if(verifyelement().booleanValue()==true)
		{
			 log.info("My Transaction is present"); 
			 System.out.println(MyTransactionstab.getText());
		}else
		{
			log.info("My Transaction is notpresent SS attached");
		}
		
		if(Beneficiariestab.getText().equals("Beneficiaries"))
		{
			 log.info("Beneficiaries is present"); 
			 System.out.println(Beneficiariestab.getText());
		}else
		{
			log.info("Beneficiaries is notpresent SS attached");
		}
		
		if(ExchangeRatetab.getText().equals("Exchange Rate"))
		{
			 log.info("Exchange Rate is present"); 
			 System.out.println(ExchangeRatetab.getText());
		}else
		{
			log.info("Exchange Rate is notpresent SS attached");
		}
		
		if(DeliverFXtab.getText().equals("Deliver FX"))
		{
			 log.info("Deliver FX is present"); 
			 System.out.println(DeliverFXtab.getText());
		}else
		{
			Assert.assertTrue(false);
			log.info("Deliver FX is notpresent SS attached");
		}
		
		String lastvisit = lastvisittab.getText();
		String lastseen = lastvisit.substring(0, 15);
		System.out.println(lastseen);
		System.out.println(lastvisit);
		if(lastseen.equals("Your last visit"))
		{
			 log.info("last Seen Verified"); 
			 System.out.println(DeliverFXtab.getText());
		}else
		{
			log.info("Last Seen Not Present");
		}
		
	}
	
}
