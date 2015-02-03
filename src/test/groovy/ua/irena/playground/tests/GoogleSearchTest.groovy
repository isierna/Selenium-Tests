package ua.irena.playground.tests

import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import ua.irena.playground.pages.GoogleMainPage

/**
 * Created by irena on 2/3/15.
 */
class GoogleSearchTest extends AbstractTest {

    GoogleMainPage page

    @BeforeTest
    public void openMainPage() {
        page = new GoogleMainPage()
        page.go()
    }

    @Test
    void searchingForFun() {
        page.searchInput.sendKeys("fun")
        page.searchInput.submit()
    }
}
