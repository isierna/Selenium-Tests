package ua.irena.playground.tests

import org.openqa.selenium.WebDriver
import org.testng.annotations.Listeners
import ua.irena.playground.utils.SeleniumSuiteListener

/**
 * Created by irena on 2/3/15.
 */
@Listeners([SeleniumSuiteListener])
abstract class AbstractTest {
    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }
}
