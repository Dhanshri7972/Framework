package stepDefination;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class LoginPageSteps {

	LoginPage login = new LoginPage();
	
@Given("user launch site url")
public void user_launch_site_url() {
   login.startApplication();
}

@When("user enter username {string} and password {string}")
public void user_enter_username_and_password(String username, String password) { 
	login.loginapplication(username,password);
}

@And("user click on login button")
public void user_click_on_login_button() {	
	login.clickOnLoginBtn();
}

@Then("validate user successfully with heading {string}")
public void validate_user_successfully_logged_in(String text) {
	login.validHeadingPage(text);
    
}
@Then("validate error is displayed")
public void Then_validate_error_is_displayed() {
	login.validErrorMsg();
}
}

	

