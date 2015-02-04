package ua.irena.playground.tests

import org.testng.Assert
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import ua.irena.playground.pages.GoogleMainPage
import ua.irena.playground.pages.GoogleSearchResultsPage


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
        page.searchInput.clear()
    }

    @Test
    void seleniumWikiPage() {
        page.searchInput.sendKeys("selenium Webdriver wiki")
        page.searchInput.submit()

        GoogleSearchResultsPage page = new GoogleSearchResultsPage()
        def link = page.getLink()
        link.click()

        page.atSearchResultsPage()

        Assert.assertEquals(driver.getTitle(), GoogleSearchResultsPage.PAGE_TITLE, "Page title is not correct")
    }
}
