import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class TestingPagesFromGoogle {
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

        WebElement elementLinkText = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Selenium (software) - Wikipedia, the free encyclopedia")))
        elementLinkText.click()

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[src*='//upload.wikimedia.org/wikipedia/en/5/5c/Seleniumlogo.png']")))

        Assert.assertEquals(driver.getTitle(), "Selenium (software) - Wikipedia, the free encyclopedia", "Page title is not correct")
    }

    @AfterTest
    void closeBrowser() {
        driver.quit()
    }

}
