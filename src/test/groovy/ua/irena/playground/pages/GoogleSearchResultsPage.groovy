package ua.irena.playground.pages

import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated


/**
 * Created by irena on 2/4/15.
 */
class GoogleSearchResultsPage extends AbstractPage {

    public WebElement getLink() {
        waitUntil presenceOfElementLocated(linkText("Selenium (software) - Wikipedia, the free encyclopedia"))
    }

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

    private static List<WebElement> getListOfElements(String selector) {
        driver.findElements(cssSelector(selector))
    }


}
