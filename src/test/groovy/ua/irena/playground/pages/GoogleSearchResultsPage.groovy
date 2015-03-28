package ua.irena.playground.pages
import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by irena on 2/4/15.
 */
class GoogleSearchResultsPage extends AbstractPage {
    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector("li.g")))
    }

    public static List<WebElement> getListOfPages() {
        getListOfElements("span.csb.gbil.ch")
    }

    public static List<WebElement> getListOfLetters() {
        getListOfElements("span.csb.gbil.ch")
    }

    public static List<WebElement> getListOfPageResults() {
        getListOfElements("li.g")
    }

    public static WebElement getLinkToPage(String selector) {
        driver.findElement(cssSelector(selector))
    }

    private static List<WebElement> getListOfElements(String selector) {
        driver.findElements(cssSelector(selector))
    }
}