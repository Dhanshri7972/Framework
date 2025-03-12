package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Helper.Base;

public class LoginPage extends Base {

	By username = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//input[@id='login-button']");
    By HeadingName = By.xpath("//span[@class='title']");
    By ErrorMsg =By.xpath("//div[@class='error-message-container error']");
	public void startApplication() {
		setup();
	}

	public void loginapplication(String uname, String pass) {

		clearAndEnter(waitForExpectedElement(username), uname);
		clearAndEnter(waitForExpectedElement(password), pass);
	}
   public void clickOnLoginBtn() {
	   
	   clickOnElement(loginBtn);
   }
   
   public void validHeadingPage(String text) {
	   validText(HeadingName,text);
     
   }  
   public void validErrorMsg() {
	   waitForExpectedElement(ErrorMsg).isDisplayed();
   }
}
