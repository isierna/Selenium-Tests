package ua.irena.playground.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import ua.irena.playground.utils.Helpers
import ua.irena.playground.utils.SeleniumSuiteListener

/**
 *  Created by irena on 2/3/15.
 */

abstract class AbstractPage {
    void go() {}

    void at() {}

    public static <T> void waitUntil(ExpectedCondition<T> expectedCondition) {
        Helpers.waitUntil(expectedCondition, driver)
    }

    public static <T> void waitUntil(ExpectedCondition<T> expectedCondition, long timeout) {
        Helpers.waitUntil(expectedCondition, timeout, driver)
    }

    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }

    public static String getPageText() {
        driver.findElement(By.tagName("body")).getText()
    }
}
