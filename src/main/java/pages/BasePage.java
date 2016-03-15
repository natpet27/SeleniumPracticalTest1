package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.SeleniumDriver;

public class BasePage {
	
	private SeleniumDriver seleniumWebDriver;

	protected BasePage() {
		seleniumWebDriver = SeleniumDriver.getInstance();
		PageFactory.initElements(seleniumWebDriver.getWebDriver(), this);
	}

	public void goToPage(String url) {
		SeleniumDriver.getInstance().getWebDriver().get(url);
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
		(new WebDriverWait(SeleniumDriver.getInstance().getWebDriver(),
				SeleniumDriver.getInstance().getTimeOutTime()))
						.until(new ExpectedCondition<Boolean>() {
							public Boolean apply(WebDriver d) {
								return d.getTitle().toLowerCase().startsWith(partialText);
							}
						});
	}
	
	public String getPageTitle() {
		return seleniumWebDriver.getWebDriver().getTitle();
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
