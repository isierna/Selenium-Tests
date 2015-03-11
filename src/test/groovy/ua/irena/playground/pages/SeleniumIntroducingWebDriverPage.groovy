package ua.irena.playground.pages
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by isierna on 2/24/2015.
 */
class SeleniumIntroducingWebDriverPage extends AbstractPage {
    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(By.cssSelector("#introducing-webdriver")), driver)
    }

    @Override
    public void go() {
        WebElement linkIntroducingWebDriver = waitUntil(presenceOfElementLocated(linkText("Introducing WebDriver")), driver)
        driver.get(linkIntroducingWebDriver.getAttribute("href"))
    }
}
