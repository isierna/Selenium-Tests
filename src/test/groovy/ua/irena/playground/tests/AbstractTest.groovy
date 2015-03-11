package ua.irena.playground.tests
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
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

    public WebElement waitUntil(ExpectedCondition expectedCondition) {
        waitUntil(expectedCondition, driver)
    }
}
