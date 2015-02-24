package ua.irena.playground.pages

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 * Created by irena on 2/9/15.
 */
class OfficialSeleniumPage extends AbstractPage{

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector("#menu_about")))
        waitUntil(presenceOfElementLocated(cssSelector("#menu_documentation")))
        waitUntil(presenceOfElementLocated(cssSelector('img[src="/images/big-logo.png"]')))
    }
}
