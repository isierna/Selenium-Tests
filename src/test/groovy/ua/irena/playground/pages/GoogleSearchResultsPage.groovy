package ua.irena.playground.pages

import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated


/**
 * Created by irena on 2/4/15.
 */
class GoogleSearchResultsPage extends AbstractPage {
    final static String LINK_TEXT = "Selenium (software) - Wikipedia, the free encyclopedia"
    static String PAGE_TITLE = "Selenium (software) - Wikipedia, the free encyclopedia"

    public WebElement getLink() {
        WebElement link = waitUntil presenceOfElementLocated(linkText(LINK_TEXT))
        return link
    }

    public atSearchResultsPage() {
        waitUntil(presenceOfElementLocated(cssSelector('img[src*="//upload.wikimedia.org/wikipedia/en/5/5c/Seleniumlogo.png"]')))
    }
}
