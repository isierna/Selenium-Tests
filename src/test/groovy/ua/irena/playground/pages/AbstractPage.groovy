package ua.irena.playground.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import ua.irena.playground.utils.Helpers
import ua.irena.playground.utils.SeleniumSuiteListener

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs

/**
 * Created by irena on 2/3/15.
 */

abstract class AbstractPage {
    void go() {}

    void at() {}

    public static WebElement getLinkByLinkText(String linktext) {
        waitUntil presenceOfElementLocated(linkText(linktext))
    }

    public static WebElement getLinkByCssSelector(String link) {
        waitUntil(presenceOfElementLocated(cssSelector(link)))
    }

    /*public static WebElement getLinkByPartialText(String linktext) {
        waitUntil(presenceOfElementLocated(partialLinkText(linktext)))
    }*/

    public static def waitUntil(ExpectedCondition expectedCondition) {
        Helpers.waitUntil(expectedCondition, driver)
    }
    public static void elementIsClickable(WebElement link ) {
        waitUntil(elementToBeClickable(link))
    }

    public static String getPageText(){
        driver.findElement(By.tagName("body")).getText()
    }

    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }

}
