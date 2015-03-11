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
        Helpers.waitUntil(presenceOfElementLocated(cssSelector("li.g")), driver)
    }

    public static List<WebElement> getListOfPages() {
        Helpers.waitUntil(presenceOfAllElementsLocatedBy(cssSelector("span.csb.gbil.ch")), driver)
    }

    public static List<WebElement> getListOfLetters() {
        Helpers.waitUntil(presenceOfAllElementsLocatedBy(cssSelector("span.csb.gbil.ch")), driver)
    }

    public static List<WebElement> getListOfPageResults() {
        Helpers.waitUntil(presenceOfAllElementsLocatedBy(cssSelector("li.g")), driver)
    }

    public static WebElement getLinkToPage(String selector) {
        Helpers.waitUntil(presenceOfElementLocated(cssSelector(selector)), driver)
    }
}