package pages;

import org.openqa.selenium.support.PageFactory;

import driver.SeleniumWebDriver;

public class BasePage {
	private final String HOME_URL = "https://www.google.com.ua";
	
	public BasePage() {
		PageFactory.initElements(SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver(), this);
	}
	
	public void goToHomePage() {
		SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver().get(HOME_URL);
	}

}
