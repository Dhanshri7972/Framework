package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Helper.Base;

public class LoginPage extends Base {

	By username = By.xpath("//input[@id='txtUsername']");
	By password = By.xpath("//input[@id='txtPassword']");
    By loginBtn = By.xpath("//button[@id='btnLogin']");
    By HeadingName = By.xpath("//li[@class='menu-title']");
    By ErrorMsg =By.xpath("//div[@class='col-lg-12 text-center text-danger']");
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
