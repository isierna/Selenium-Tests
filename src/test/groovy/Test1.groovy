import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
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


    void firstTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/irena/System/chromedriver")

        def driver = new ChromeDriver()

        driver.get("http://www.google.com")

        driver.quit()

    }
}
