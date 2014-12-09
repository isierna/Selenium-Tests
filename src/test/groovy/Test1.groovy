import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class Test1 {
    WebDriver driver

    @BeforeTest
    void openBrowser() {
        driver = new FirefoxDriver()
    }

    @AfterTest
    void closeBrowser() {
        driver.quit()
    }

    @Test
    void secondTest() {

        driver.get("http://www.google.com")
    }
}
