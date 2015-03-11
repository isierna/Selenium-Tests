package ua.irena.playground.utils

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

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

    public static String getPageText() {
        driver.findElement(By.tagName("body")).getText()
    }

    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }
}


