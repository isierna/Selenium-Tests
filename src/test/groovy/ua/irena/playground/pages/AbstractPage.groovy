package ua.irena.playground.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import ua.irena.playground.utils.Helpers
import ua.irena.playground.utils.SeleniumSuiteListener

/**
 * Created by irena on 2/3/15.
 */

abstract class AbstractPage {
    void go() {}

    void at() {}

    public WebElement waitUntil(ExpectedCondition expectedCondition) {
        Helpers.waitUntil(expectedCondition, driver)
    }

    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }

}
