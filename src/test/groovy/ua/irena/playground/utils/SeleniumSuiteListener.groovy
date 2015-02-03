package ua.irena.playground.utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.ISuite
import org.testng.ISuiteListener

/**
 * Created by irena on 2/3/15.
 */
class SeleniumSuiteListener implements ISuiteListener{

    private static WebDriver fireFox

    @Override
    void onStart(ISuite suite) {
        fireFox = new FirefoxDriver()
    }

    @Override
    void onFinish(ISuite suite) {
        fireFox.quit()
    }

    static WebDriver getDriver() {
        fireFox
    }
}
