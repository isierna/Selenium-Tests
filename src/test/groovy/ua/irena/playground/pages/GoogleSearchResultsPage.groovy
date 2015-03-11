package ua.irena.playground.pages
import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by irena on 2/4/15.
 */
class GoogleSearchResultsPage extends AbstractPage {
    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector("li.g")), driver)
    }

    public static List<WebElement> getListOfPages() {
        waitUntil(presenceOfAllElementsLocatedBy(cssSelector("span.csb.gbil.ch")), driver)
    }

    public static List<WebElement> getListOfLetters() {
        waitUntil(presenceOfAllElementsLocatedBy(cssSelector("span.csb.gbil.ch")), driver)
    }

    public static List<WebElement> getListOfPageResults() {
        waitUntil(presenceOfAllElementsLocatedBy(cssSelector("li.g")), driver)
    }

    public static WebElement getLinkToPage(String selector) {
        waitUntil(presenceOfElementLocated(cssSelector(selector)), driver)
    }
}