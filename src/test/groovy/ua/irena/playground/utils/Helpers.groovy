package ua.irena.playground.utils

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Created by irena on 2/3/15.
 */
class Helpers {
    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }

    public static final long DEFAULT_WAIT = 10L

    public static def waitUntil(ExpectedCondition expectedCondition, WebDriver driver) {
        waitUntil(expectedCondition, DEFAULT_WAIT, driver)
    }

    public static def waitUntil(ExpectedCondition expectedCondition, long timeout, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, timeout)
        wait.until(expectedCondition)
    }

    public static String generateRandomString() {
        RandomStringUtils randomObject = new RandomStringUtils()
        randomObject.randomAlphabetic(7)
    }

    public static String generateRandomNumber() {
        RandomStringUtils randomObject = new RandomStringUtils()
        randomObject.randomNumeric(3)
    }
}

