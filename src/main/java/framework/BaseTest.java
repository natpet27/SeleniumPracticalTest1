package framework;

import org.testng.annotations.AfterMethod;

import pages.BasePage;

public class BaseTest extends BasePage {

	@AfterMethod
	public void tearDown() {
		if (SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver() != null) {
			SeleniumWebDriver.getSeleniumWebDriverInstance()
					.quitSeleniumWebDriver();
		}
	}
}
