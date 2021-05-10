package com.demo.amexchange.stepdefination;


import com.demo.amexchange.pageObject.AddBeneficiariesPageObject;

import io.cucumber.java.en.*;

public class AddBeneficiariesstepdef extends BaseClass {

	AddBeneficiariesPageObject addbenificiares;
	
	
	@Given("User is on dahboard")
	public void user_is_on_dahboard() {
	
		addbenificiares = new AddBeneficiariesPageObject(driver);
		
		
	}
	
	@Then("User click on Benificaries tab")
	public void user_click_on_benificaries_tab(){
		addbenificiares.verifiyhome();
		log.info("user is on Home Page");
		addbenificiares.clickonaddbeni();
		log.info("User Select tab as ADA benificiaries");
	}
	
	@And("verify security question")
	public void verify_security_question () {
		addbenificiares.handelsecurityquestion();
		log.info("Security Question is handled");
	}
	
	
	@Then("user click on add benificaries and select ABA")
	public void user_click_on_add_benificaries_and_select_aba() {
		log.info("User Select tab as ADA benificiaries");
	}
	
	@Then("user upload file and enter a notes")
	public void user_upload_file_and_enter_a_notes() {
		addbenificiares.uploadimage();
		log.info("image uploded succesfully");
	}
	
	@Then("User click on save button")
	public void user_click_on_save_button() {
		log.info("User Click on save button successful");
	}
	
	@And("verifiy success message and click ok")
	public void verifiy_success_message_and_click_ok() {
		addbenificiares.verifysuccessandok();
		log.info("Benificiries test case pass");
	}
	
	@Then("User click on Add beni and select abyourself")
	public void user_click_on_add_beni_and_select_abyourself() throws InterruptedException{
		addbenificiares.verifyabyourself(rc.getCountry());
		log.info("ser click on Add beni and select abyourself");
	}
}
