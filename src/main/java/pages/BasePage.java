package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.SeleniumWebDriver;

public class BasePage {

	protected BasePage() {
		PageFactory.initElements(SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver(), this);
	}

	public void goToPage(String url) {
		SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver().get(url);
	}

	protected void enterTextIntoTextField(WebElement textField, String text) {
		textField.click();
		textField.clear();
		textField.sendKeys(text);
	}

	protected void clickOnWebElement(WebElement webElement) {
		webElement.click();
	}

	public void waitUntilPageTitleStartsWithPartialText(final String partialText) {
		(new WebDriverWait(SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver(),
				SeleniumWebDriver.getSeleniumWebDriverInstance().getTimeOutTime()))
						.until(new ExpectedCondition<Boolean>() {
							public Boolean apply(WebDriver d) {
								return d.getTitle().toLowerCase().startsWith(partialText);
							}
						});
	}
	
	public String getPageTitle() {
		return SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver().getTitle();
	}
	
	public void waitForPageLoad1() {
	
	   WebDriverWait wait = new WebDriverWait(SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver(), 30);

	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	}
	
	@BeforeMethod() 
	public void setUp() {
		SeleniumWebDriver.getSeleniumWebDriverInstance();
	}
	
	@AfterMethod() 
	public void tearDown() {
		SeleniumWebDriver.getSeleniumWebDriverInstance().getWebDriver().quit();
	}
}
