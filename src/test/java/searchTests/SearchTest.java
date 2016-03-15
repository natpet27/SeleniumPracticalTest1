package searchTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.BaseTest;
import framework.SeleniumDriver;
import pages.GoogleHomePage;

public class SearchTest extends BaseTest {

	@Test
	public void searchByWordTest1() {
		String searchPhrase = "Cheese!";
		String expectedPageTitle = "Cheese1! - Пошук Google";
		String expectedPageTitlePartialText = "cheese";
		String actualPagetitleBeforeSearch;
		String actualPageTitleAfterSearch;

		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.goToHomePage();
		googleHomePage.searchByText(searchPhrase);
		// Check the title of the page
		actualPagetitleBeforeSearch = googleHomePage.getPageTitle();
		System.out.println("Page title before search is: " + actualPagetitleBeforeSearch);

		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds
		googleHomePage
				.waitUntilPageTitleStartsWithPartialText(expectedPageTitlePartialText);

		// Should see: "cheese! - Google Search"
		actualPageTitleAfterSearch =  googleHomePage.getPageTitle();
		System.out.println("Page after search is: " + actualPageTitleAfterSearch);
		Assert.assertEquals(actualPageTitleAfterSearch, expectedPageTitle, "Actual page title is incorrect");
		
		SeleniumDriver.getInstance().quitSeleniumDriver();
		System.out.println("webdriver is: " + SeleniumDriver.getInstance().getWebDriver());
	}
}
