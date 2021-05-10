Feature: AMEWebTestCases

@highleveltest	
Scenario: Check Login with vaild cridintials 
	Given User Launch any web application
	When User goto website "https://appb-kwt.almullaexchange.com/login"
	Then user set Civil ID as civil
	And set Password 
	Then user click on login 
	And verifiy invite user and close invite 
	Then verifiy page title, last visit and all five tab name 
	
@highleveltest	
Scenario: Adding benificiaries to account 
	Given User is on dahboard 
	Then User click on Benificaries tab 
	And verify security question 
	Then user click on add benificaries and select ABA
	Then user upload file and enter a notes 
	Then User click on save button   
	And verifiy success message and click ok 
	Then User click on Add beni and select abyourself