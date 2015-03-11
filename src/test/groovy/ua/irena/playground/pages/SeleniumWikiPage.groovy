package ua.irena.playground.pages

import org.openqa.selenium.WebElement
import ua.irena.playground.utils.Helpers

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 * Created by irena on 2/5/15.
 */
class SeleniumWikiPage extends AbstractPage {
    static String PAGE_TITLE = "Selenium (software) - Wikipedia, the free encyclopedia"

    @Override
    public void at() {
        Helpers.waitUntil(presenceOfElementLocated(cssSelector("img[src*='//upload.wikimedia.org/wikipedia/en/5/5c/Seleniumlogo.png']")), driver)
    }

    @Override
    public static void go() {
        WebElement link = Helpers.waitUntil(presenceOfElementLocated(linkText("Selenium (software) - Wikipedia, the free encyclopedia")), driver)
        link.click()
    }
}

