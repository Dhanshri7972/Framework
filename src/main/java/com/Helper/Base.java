package com.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {

	public static WebDriver driver;
	public static Properties p;

	static {

		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/env.properties");
			p = new Properties();
			p.load(file);
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setup() {
		String browserName = p.getProperty("Browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void selectValueFromText(WebElement ele, String value) {

		Select s = new Select(ele);
		s.selectByVisibleText(value);
	}

	public void selctValueFromBootstrapDropDown(List<WebElement> ele, String value) {

		for (WebElement e : ele) {

			String text = e.getText();

			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void selectWindow(String title) {

		Set<String> windows = driver.getWindowHandles();

		for (String w : windows) {
			driver.switchTo().window(w);
			String actualTitle = driver.getTitle();

			if (actualTitle.equals(title)) {
				break;
			}
		}
	}

	public void mouseover(WebElement ele) {

		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
	}

	public WebElement waitForExpectedElement(By locator) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		return w.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void waitForClickElement(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void clickOnElement(WebElement ele) {
		try {
			ele.click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click;", ele);
		}

	}

	public void clickOnElement(By locator) {

		try {
			waitForExpectedElement(locator).click();
		} catch (Exception e) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("", waitForExpectedElement(locator));

		}

	}
	
	public void selectAlertPopup() {

		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void clearAndEnter(WebElement ele, String text) {
		ele.clear();
		ele.sendKeys(text);
	}

	public void selectDropDownIndex(WebElement ele, int num) {
		Select s = new Select(ele);
		s.selectByIndex(num);
	}
   public void validText(By locator,String expectedText) {
	   String actualText =waitForExpectedElement(locator).getText();
		 org.junit.Assert.assertEquals(expectedText, actualText);
   }
	
	public void tearDown(Scenario Status) {

		if (Status.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(src,
						new File(System.getProperty("user.dir") + "/Screenshot/" + Status.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.quit();
	}

}
