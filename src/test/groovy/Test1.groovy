import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

import java.util.concurrent.TimeUnit

class Test1 {
    WebDriver driver

    @BeforeTest
    void openBrowser() {
        driver = new FirefoxDriver()
    }


    @Test
    void secondTest() {
        driver.get("http://www.google.com")
        WebElement searchInput = driver.findElement(By.id("gbqfq"))
        searchInput.sendKeys("selenium Webdriver wiki")
        searchInput.submit()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

        WebElement wikiSelenium = driver.findElement(By.linkText("Selenium (software) - Wikipedia, the free encyclopedia"))
        wikiSelenium.click()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

        String a = driver.getTitle()
        a.equals("Selenium (software) - Wikipedia, the free encyclopedia")

    }

    @AfterTest
    void closeBrowser() {
        driver.quit()
    }

}
