package ua.irena.playground.pages

import org.openqa.selenium.WebElement
import ua.irena.playground.utils.Helpers

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated


/**
 * Created by irena on 2/4/15.
 */
class GoogleSearchResultsPage extends AbstractPage {
    @Override
    public void at() {
        Helpers.waitUntil(presenceOfElementLocated(cssSelector("li.g")))
    }

    public static void goToSeleniumWikiPage() {
        def link = Helpers.getLinkByLinkText("Selenium (software) - Wikipedia, the free encyclopedia")
        link.click()
    }

    public static List<WebElement> getListOfPages() {
        Helpers.waitUntil(presenceOfAllElementsLocatedBy(cssSelector("span.csb.gbil.ch")))
    }

    public static List<WebElement> getListOfLetters() {
        Helpers.waitUntil(presenceOfAllElementsLocatedBy(cssSelector("span.csb.gbil.ch")))
    }

    public static List<WebElement> getListOfPageResults() {
        Helpers.waitUntil(presenceOfAllElementsLocatedBy(cssSelector("li.g")))
    }
}
