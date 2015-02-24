package ua.irena.playground.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import ua.irena.playground.utils.Helpers
import ua.irena.playground.utils.SeleniumSuiteListener

import static org.openqa.selenium.By.linkText
import static org.openqa.selenium.By.partialLinkText
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 * Created by irena on 2/3/15.
 */

abstract class AbstractPage {
    void go() {}

    void at() {}

    public static WebElement getLink(String linktext) {
        waitUntil presenceOfElementLocated(linkText(linktext))
    }

    public static WebElement getLinkByPartialText(String linktext) {
        waitUntil(presenceOfElementLocated(partialLinkText(linktext)))
    }

    public static def waitUntil(ExpectedCondition expectedCondition) {
        Helpers.waitUntil(expectedCondition, driver)
    }


    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }

}
