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
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.cucumber.java.After;
import io.cucumber.java.en.*;

import com.demo.amexchange.pageObject.LoginScnarioObject;


public class LoginScnario extends BaseClass{
	
	LoginScnarioObject lg;
	BaseClass base;

	public void quit()
	{
		driver.quit();
		log.info("execution completed");
	}
	
	
	@Given("User Launch any web application")
	public void user_launch_any_web_application() {
		base = new BaseClass();
		base.setup(rc.getBrowser());
		lg = new LoginScnarioObject(driver);
		
	}

	@When("User goto website {string}")
	public void user_goto_website(String string) {

		driver.get(baseURL);
		log.info("Website almullaexchange open success");
	}

	@Then("user set Civil ID as civil")
	public void user_set_civil_id_as_civil() {
		lg.setusermane(UserName);
		log.info("username set success");
	}

	@Then("set Password")
	public void set_password() {
		lg.setpassword(Password); 
		log.info("password set success");
	}

	@Then("user click on login")
	public void user_click_on_login() {
		lg.clicklogin();
		log.info("login click success");
	}

	@Then("verifiy invite user and close invite")
	public void verifiy_invite_user_and_close_invite() throws IOException {
		 lg.closeinvite();
		 log.info("Invite Friend tab handle sucssfully");
	}

	@Then("verifiy page title, last visit and all five tab name")
	public void verifiy_page_title_last_visit_and_all_five_tab_name() {
		lg.verifytabelastvsit();
		log.info("All Tab Present and Last visit verified");
	}
	

}
