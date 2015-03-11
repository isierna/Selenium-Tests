package ua.irena.playground.pages
import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by irena on 2/9/15.
 */
class OfficialSeleniumPage extends AbstractPage {
    String officialPageLink = 'a[href*="www.seleniumhq.org"]'

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector("#menu_about")), driver)
        waitUntil(presenceOfElementLocated(cssSelector("#menu_documentation")), driver)
        waitUntil(presenceOfElementLocated(cssSelector('img[src="/images/big-logo.png"]')), driver)
    }

    public static WebElement getLinkToPage(String text) {
        waitUntil(presenceOfElementLocated(linkText(text)), driver)
    }
}
