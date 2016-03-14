import org.testng.annotations.Test;

import pages.BasePage;

public class SearchTest {
	
	@Test
	public void searchByWordTest() {
		BasePage basePage = new BasePage();
		basePage.goToHomePage();
	}

}
