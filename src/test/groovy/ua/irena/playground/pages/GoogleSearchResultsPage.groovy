package ua.irena.playground.pages

import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
//import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated


/**
 * Created by irena on 2/4/15.
 */
class GoogleSearchResultsPage extends AbstractPage {

//    public static WebElement getLink(String linktext) {
//        waitUntil presenceOfElementLocated(linkText(linktext))
//    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector("li.g")))
    }

    public static List<WebElement> getListOfPages() {
        waitUntil(presenceOfAllElementsLocatedBy(cssSelector("span.csb.gbil.ch")))
    }

    public static List<WebElement> getListOfLetters() {
        waitUntil(presenceOfAllElementsLocatedBy(cssSelector("span.csb.gbil.ch")))
    }

    public static List<WebElement> getListOfPageResults() {
        waitUntil(presenceOfAllElementsLocatedBy(cssSelector("li.g")))
    }

    public static WebElement getSeleniumLink(String link) {
        waitUntil(presenceOfElementLocated(cssSelector(link)))
    }
}
