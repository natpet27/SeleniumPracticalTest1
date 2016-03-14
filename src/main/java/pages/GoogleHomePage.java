package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage {
	
	private final String HOME_URL = "https://www.google.com.ua";
	
	@FindBy (name="q")
	private WebElement searchTextField;
	
	public void goToHomePage() {
		goToPage(HOME_URL);
	}
	
	private void enterTextIntoSearchTextField(String text) {
		enterTextIntoTextField(searchTextField, text);
	}
	
	public void searchByText(String text) {
		enterTextIntoSearchTextField(text);
		searchTextField.submit();
	}
}
