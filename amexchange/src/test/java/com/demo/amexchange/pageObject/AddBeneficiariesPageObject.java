package com.demo.amexchange.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.amexchange.stepdefination.BaseClass;

public class AddBeneficiariesPageObject extends BaseClass {

	WebDriver ldriver;
	Actions actions;

	public AddBeneficiariesPageObject(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[1]/div[1]/a/img") WebElement homepage;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[1]/a[3]") WebElement benificiatab;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[3]/div[3]/div[2]") WebElement loadingcontaint;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[3]/div[1]/div[3]/span") WebElement addbenificaries;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[3]/div[6]/div[3]") WebElement selectada;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/h4") WebElement verifiysecutiryqution;
	@FindBy(id="securityQuestion") WebElement txtsecurityquetion;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div[3]/button[2]") WebElement btnnextsecurityqetion;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div/h4") WebElement veriyinsertimagepage;

	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div/div/div[1]/div/div[1]/div/input") WebElement choosefile;
	@FindBy(id="note") WebElement notesdec;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div/div/div[2]/button[2]") WebElement btnsave;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div/h4") WebElement verifiysuccessmsg;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[1]/div[1]/a/img") WebElement clickonok;


	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div/div[3]/div[6]/div[2]") WebElement abyourself;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div[3]/div[2]/div/h4") WebElement verfiyonchangecountrypage;
	@FindBy(id="react-select-6--value") WebElement selectcountry;
	@FindBy(xpath="//*[@id=\"react-select-8--value\"]/div[1]") WebElement selectbank;
	@FindBy(id="BANKING CHANNEL") WebElement radiobtnbank;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div[3]/div[2]/div/div[3]/button[2]") WebElement selectnext;
	@FindBy(xpath="//*[@id=\"react-select-7--value\"]/div[1]") WebElement selecouancy;

	

	public void verifiyhome()
	{
		homepage.isDisplayed();
		homepage.click();
		log.info("User is on Home Page");
	}

	public void clickonaddbeni()
	{
		wait.WaitForElement(benificiatab, 60);
		benificiatab.click();
		log.info("Benificiaries Tab Clicked");
		// wait.WaitForElement(loadingcontaint, 60);
		// loadingcontaint.isDisplayed();
		// log.info("Beni Page Loaded Succesfully");
		wait.WaitForElement(addbenificaries, 60);
		addbenificaries.click();
		wait.WaitForElement(selectada, 60);
		selectada.click();
		log.info("ADA type beni selected");
	}

	public void handelsecurityquestion()
	{
		wait.WaitForElement(verifiysecutiryqution, 60);
		System.out.println(verifiysecutiryqution.getText());
		log.info("on secutity question page");
		wait.WaitForElement(txtsecurityquetion, 60);
		txtsecurityquetion.sendKeys("test");
		btnnextsecurityqetion.click();
		log.info("security qutionn ans provided and clicked next");

	}

	public void uploadimage()
	{
		wait.WaitForElement(veriyinsertimagepage, 60);
		System.out.println(veriyinsertimagepage.getText());
		choosefile.sendKeys("C:/Users/user/git/almullaexchange/amexchange/Screenshots/testlogin.png");
		log.info("Screenshootfile uploaded sucessfully");
		wait.WaitForElement(notesdec, 60);
		notesdec.sendKeys("file uploaded test");
		log.info("sendkynots success");
		btnsave.click();
		log.info("save button clicked successfully");


	}

	public void verifysuccessandok()
	{
		wait.WaitForElement(verifiysuccessmsg, 60);
		String succes = verifiysuccessmsg.getText();
		if(succes.equalsIgnoreCase("Beneficiary Details Upload"))
		{
			log.info("Benificiaries Added Successfully");
		}else
		{
			log.info("Error while Adding Benificiaries");
		}

		wait.WaitForElement(clickonok, 60);
		clickonok.click();
		log.info("OK button clicked successfully");	
	}

	public void verifyabyourself(String countryname) throws InterruptedException
	{
		wait.WaitForElement(benificiatab, 60);
		benificiatab.click();
		addbenificaries.click();
		abyourself.click();
		wait.WaitForElement(verfiyonchangecountrypage, 60);
		System.out.println(verfiyonchangecountrypage.getText());
		log.info("We are on Change Country Page");
		wait.WaitForElement(selectcountry, 60);
		System.out.println(selectcountry.isDisplayed());
		selectcountry.isDisplayed();
		selectcountry.click();

		Thread.sleep(5000);
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div[3]/div[2]/div/div[1]/div[1]/div/div"));
		System.out.println(allOptions.size());
		for(int i = 0; i<=allOptions.size()-1; i++) {
			if(allOptions.get(i).getText().contains(countryname)) {
				log.info("if part executed");
				System.out.println(allOptions.get(i).getText());
				System.out.println(countryname);
				System.out.println(i);
				allOptions.get(i).click();
				log.info("Country Selcted");
			} 
			else
			{
				log.info("else part executed");
			}
		}

		selecouancy.isDisplayed();
		selecouancy.click();
		
		List<WebElement> allOptionscurancy = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div[3]/div[2]/div/div[1]/div[3]/div/div"));
		System.out.println(allOptionscurancy.size());
		for(int i = 0; i<=allOptionscurancy.size()-1; i++) {
			if(allOptionscurancy.get(i).getText().contains("EUR -Euro")) {
				log.info("if part executed");
				System.out.println(allOptionscurancy.get(i).getText());
				System.out.println(countryname);
				System.out.println(i);
				allOptionscurancy.get(i).click();
				log.info("Country Selcted");
			} 
			else
			{
				log.info("else part executed");
			}
		}
		
		System.out.println(selectbank.isDisplayed());
		selectbank.click();
		
		List<WebElement> allOptionbank = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div[3]/div[2]/div/div[1]/div[4]/div/div"));
		System.out.println(allOptionbank.size());
		for(int i = 0; i<=allOptionbank.size()-1; i++) {
			if(allOptionbank.get(i).getText().contains("EUR -Euro")) {
				log.info("if part executed");
				System.out.println(allOptionbank.get(i).getText());
				System.out.println(countryname);
				System.out.println(i);
				allOptionbank.get(i).click();
				log.info("Country Selcted");
			} 
			else
			{
				log.info("else part executed");
			}
		}

	}



}
