
Feature: Title of your feature
  
 
  
  @Regression
  Scenario: verify login with multiple set of data
  
  Given user launch site url
  When user enter username "standard_user" and password "secret_sauce"
  And user click on login button
  Then validate user successfully with heading "Products"
  
@Regression
  Scenario: verify login with invalid input data
   Given user launch site url
   When user enter username "user1" and password "pass1"
    And user click on login button
    Then validate error is displayed