package ua.irena.playground.pages

import org.openqa.selenium.WebDriver
import ua.irena.playground.utils.SeleniumSuiteListener
/**
 * Created by irena on 2/3/15.
 */

abstract class AbstractPage {
    void go() {}

    void at() {}

    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }
}
