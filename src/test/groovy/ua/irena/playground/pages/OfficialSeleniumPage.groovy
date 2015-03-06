package ua.irena.playground.pages

import ua.irena.playground.utils.Helpers

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 * Created by irena on 2/9/15.
 */
class OfficialSeleniumPage extends AbstractPage{

    @Override
    public void at() {
        Helpers.waitUntil(presenceOfElementLocated(cssSelector("#menu_about")))
        Helpers.waitUntil(presenceOfElementLocated(cssSelector("#menu_documentation")))
        Helpers.waitUntil(presenceOfElementLocated(cssSelector('img[src="/images/big-logo.png"]')))
    }
}
