package ua.irena.playground.tests

import org.openqa.selenium.WebElement
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import ua.irena.playground.pages.*

import static org.testng.Assert.assertEquals
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
        resultsPage.goToSeleniumWikiPage()

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

        resultsPage.Helpers.getLinkByCssSelector('a[href*="www.seleniumhq.org"]').click()

        officialSeleniumPage = new OfficialSeleniumPage()
        officialSeleniumPage.at()

        officialSeleniumPage.Helpers.getLinkByLinkText("Documentation").click()


        seleniumDocumentation = new SeleniumDocumentation()
        seleniumDocumentation.at()
        String srcValueJavaButton = seleniumDocumentation.getJavaButton().getAttribute("src")
        seleniumDocumentation.selectingJavaLanguageOnlyIfNotSelected(srcValueJavaButton)

        WebElement linkIntroducingWebDriver = seleniumDocumentation.getLinkByLinkText("Introducing WebDriver")
        seleniumDocumentation.elementIsClickable(linkIntroducingWebDriver)
        driver.get(linkIntroducingWebDriver.getAttribute("href"))


        seleniumIntroducingWebDriverPage = new SeleniumIntroducingWebDriverPage()
        seleniumIntroducingWebDriverPage.at()
        String b = seleniumIntroducingWebDriverPage.getPageText()
        assertTrue(b.contains("org.seleniumhq.selenium"))

    }
}




