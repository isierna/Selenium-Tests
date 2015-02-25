package ua.irena.playground.tests

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import ua.irena.playground.pages.OfficialSeleniumPage
import ua.irena.playground.pages.SeleniumDocumentation
import ua.irena.playground.pages.SeleniumIntroducingWebDriverPage
import ua.irena.playground.pages.SeleniumWikiPage

import static org.testng.Assert.assertEquals
import org.testng.annotations.Test
import ua.irena.playground.pages.GoogleMainPage
import ua.irena.playground.pages.GoogleSearchResultsPage

import static org.testng.Assert.assertTrue

/**
 * Created by irena on 2/3/15.
 */
class GoogleSearchTest extends AbstractTest {

    GoogleMainPage page
    GoogleSearchResultsPage resultsPage
    OfficialSeleniumPage officialSeleniumPage
    SeleniumDocumentation seleniumDocumentation
    SeleniumIntroducingWebDriverPage seleniumIntroducingWebDriverPage

    @BeforeMethod
    public void openMainPage() {
        page = new GoogleMainPage()
        page.go()
    }

    @AfterMethod
    public void openBlankPage() {
        driver.get("about:blank")
    }

    @Test
    void searchingForFun() {
        page.searchInput.sendKeys("fun")
        page.searchInput.submit()
    }

    @Test
    void seleniumWikiPage() {
        page.searchInput.sendKeys("selenium Webdriver wiki")
        page.searchInput.submit()

        resultsPage = new GoogleSearchResultsPage()
        resultsPage.at()

        def link = resultsPage.getLinkByLinkText("Selenium (software) - Wikipedia, the free encyclopedia")
        link.click()

        SeleniumWikiPage wikiPage = new SeleniumWikiPage()
        wikiPage.at()

        assertEquals(driver.getTitle(), SeleniumWikiPage.PAGE_TITLE, "Page title is not correct")
    }

    @Test
    void checkThatGoogleSignHas10Letters() {
        page.searchInput.sendKeys("InteliJ IDEA")
        page.searchInput.submit()

        resultsPage = new GoogleSearchResultsPage()
        resultsPage.at()
        List<WebElement> listLettersFound = resultsPage.getListOfLetters()

        assertEquals(listLettersFound.size(), 10, "Not 10 Letters")

    }

    @Test
    void numberOfPagesInPagination() {
        page.searchInput.sendKeys("InteliJ IDEA")
        page.searchInput.submit()

        resultsPage = new GoogleSearchResultsPage()
        resultsPage.at()
        int pagesFound = resultsPage.getListOfPages().size()

        assertTrue(pagesFound >= 10, "Number of pages is less than 10")
    }

    @Test
    void confirmingNumberOfResultsAfterSearch() {
        page.searchInput.sendKeys("Web Driver")
        page.searchInput.submit()

        resultsPage = new GoogleSearchResultsPage()
        resultsPage.at()

        List<WebElement> listPageResults = resultsPage.getListOfPageResults()

        assertEquals(listPageResults.size(), 10, "Results are not 10")

    }

    @Test
    void findOfficialSeleniumSite() {
        page.searchInput.sendKeys("selenium")
        page.searchInput.submit()

        resultsPage = new GoogleSearchResultsPage()
        resultsPage.at()

        resultsPage.getLinkByCssSelector('a[href*="www.seleniumhq.org"]').click()

        officialSeleniumPage = new OfficialSeleniumPage()
        officialSeleniumPage.at()

        officialSeleniumPage.getLinkByLinkText("Documentation").click()


        seleniumDocumentation = new SeleniumDocumentation()
        seleniumDocumentation.at()
        String srcValueJavaButton = seleniumDocumentation.getJavaButton().getAttribute("src")
        seleniumDocumentation.selectingJavaLanguageOnlyIfNotSelected(srcValueJavaButton)

        WebElement linkIntroducingWebDriver = seleniumDocumentation.getLinkByLinkText("Introducing WebDriver")
        seleniumDocumentation.elementIsClickable(linkIntroducingWebDriver)
        linkIntroducingWebDriver.click()

    }
}




