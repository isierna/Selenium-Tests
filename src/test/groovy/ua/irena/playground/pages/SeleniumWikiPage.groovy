package ua.irena.playground.pages

import ua.irena.playground.utils.Helpers

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 * Created by irena on 2/5/15.
 */
class SeleniumWikiPage extends AbstractPage {
    static String PAGE_TITLE = "Selenium (software) - Wikipedia, the free encyclopedia"

    public void at() {
        Helpers.waitUntil(presenceOfElementLocated(cssSelector("img[src*='//upload.wikimedia.org/wikipedia/en/5/5c/Seleniumlogo.png']")))
    }
}

