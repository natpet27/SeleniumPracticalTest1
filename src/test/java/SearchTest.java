import org.testng.annotations.Test;

import framework.BaseTest;
import pages.GoogleHomePage;

public class SearchTest extends BaseTest {
	
	@Test
	public void searchByWordTest1() {
		final String expectedPageTitle = "cheese!";
		final String searchPhrase = "Cheese!";
		
		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.goToHomePage();
		googleHomePage.searchByText(searchPhrase);
		// Check the title of the page
        System.out.println("Page title is: " + googleHomePage.getPageTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        googleHomePage.waitUntilPageTitleStartsWithPartialText(expectedPageTitle);

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + googleHomePage.getPageTitle());
	}
}
