package ua.irena.playground.pages
import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by irena on 2/5/15.
 */
class SeleniumWikiPage extends AbstractPage {
    static final String PAGE_TITLE = "Selenium (software) - Wikipedia, the free encyclopedia"

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector("img[src*='//upload.wikimedia.org/wikipedia/en/5/5c/Seleniumlogo.png']")))
    }

    @Override
    public void go() {
        WebElement link = driver.findElement(linkText("Selenium (software) - Wikipedia, the free encyclopedia"))
        link.click()
    }
}

