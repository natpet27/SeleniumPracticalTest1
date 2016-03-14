package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumWebDriver {
	private static SeleniumWebDriver seleniumWebDriver;
	private WebDriver webDriver;
	private final int timeOutTimeInSeconds = 10;
	
	private SeleniumWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public static SeleniumWebDriver getSeleniumWebDriverInstance() {
		if(seleniumWebDriver == null) {
			seleniumWebDriver = new SeleniumWebDriver(new FirefoxDriver());
		}
		return seleniumWebDriver;
	}
	
	public int getTimeOutTime() {
		return timeOutTimeInSeconds;
	}
	
	public void quitSeleniumWebDriver() {
		getSeleniumWebDriverInstance().getWebDriver().quit();
	}
}
