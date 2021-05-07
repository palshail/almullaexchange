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