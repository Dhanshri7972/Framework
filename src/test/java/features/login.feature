
Feature: Login e-care Webapplication
  
 
  
  @Regression
  Scenario: verify user login with valid input data
  
  Given user launch site url
  When user enter username "sf001" and password "Francis1988"
  And user click on login button
  Then validate user successfully with heading "Menu"
  
@Regression
  Scenario: verify user login with invalid input data
   Given user launch site url
   When user enter username "user1" and password "pass1"
   And user click on login button
   Then validate error is displayed