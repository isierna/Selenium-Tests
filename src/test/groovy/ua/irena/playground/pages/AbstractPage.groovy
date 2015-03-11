package ua.irena.playground.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
import ua.irena.playground.utils.SeleniumSuiteListener

/**
 * Created by irena on 2/3/15.
 */

abstract class AbstractPage {
    void go() {}

    void at() {}

    public static final long DEFAULT_WAIT = 10L

    public static def waitUntil(ExpectedCondition expectedCondition, WebDriver driver) {
        waitUntil(expectedCondition, DEFAULT_WAIT, driver)
    }

    public static def waitUntil(ExpectedCondition expectedCondition, long timeout, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, timeout)
        wait.until(expectedCondition)
    }

    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }

    public static String getPageText() {
        driver.findElement(By.tagName("body")).getText()
    }
}
