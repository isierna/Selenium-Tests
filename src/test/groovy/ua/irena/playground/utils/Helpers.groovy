package ua.irena.playground.utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by irena on 2/3/15.
 */
class Helpers {
    public static final long DEFAULT_WAIT = 10L

    public static def waitUntil(ExpectedCondition expectedCondition, WebDriver driver) {
        waitUntil(expectedCondition, DEFAULT_WAIT, driver)
    }

    public static def waitUntil(ExpectedCondition expectedCondition, long timeout, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, timeout)
        wait.until(expectedCondition)
    }

    public static WebElement getLinkByLinkText(String linktext) {
        waitUntil presenceOfElementLocated(linkText(linktext))
    }

    public static WebElement getLinkByCssSelector(String link) {
        waitUntil(presenceOfElementLocated(cssSelector(link)))
    }

    public static WebElement getElementByCssSelector(String selector) {
        waitUntil(presenceOfElementLocated(cssSelector(selector)))
    }

    public static def waitUntil(ExpectedCondition expectedCondition) {
        waitUntil(expectedCondition, driver)
    }

    public static String getPageText() {
        driver.findElement(By.tagName("body")).getText()
    }

    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }
}


