package ua.irena.playground.pages
import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by irena on 2/9/15.
 */
class OfficialSeleniumPage extends AbstractPage {
    final static String OFFICIAL_PAGE_LINK = 'a[href*="www.seleniumhq.org"]'

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector("#menu_about")))
        waitUntil(presenceOfElementLocated(cssSelector("#menu_documentation")))
        waitUntil(presenceOfElementLocated(cssSelector('img[src="/images/big-logo.png"]')))
    }

    public static WebElement getLinkToPage(String text) {
        driver.findElement(linkText(text))
    }
}
