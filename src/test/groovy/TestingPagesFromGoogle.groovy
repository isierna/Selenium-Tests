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

import static org.testng.Assert.assertTrue

class TestingPagesFromGoogle extends ChangedParams{
    WebDriver driver

    @BeforeTest
    void openBrowser() {
        driver = new FirefoxDriver()
    }


    @Test
    void SeleniumWikiPage() {
        driver.get("http://www.google.com")

        WebElement searchInput = driver.findElement(By.id("gbqfq"))
        searchInput.sendKeys("selenium Webdriver wiki")
        searchInput.submit()

        WebElement elementLinkText = (new WebDriverWait(driver, variableForWaiter)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Selenium (software) - Wikipedia, the free encyclopedia")))
        elementLinkText.click()

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[src*='//upload.wikimedia.org/wikipedia/en/5/5c/Seleniumlogo.png']")))

        Assert.assertEquals(driver.getTitle(), "Selenium (software) - Wikipedia, the free encyclopedia", "Page title is not correct")
    }

    @Test
    void WebDriverSearch() {
        driver.get("http://www.google.com")

        WebElement searchInput = driver.findElement(By.id("gbqfq"))
        searchInput.sendKeys("Webdriver")
        searchInput.submit()

        (new WebDriverWait(driver, variableForWaiter)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.g")))
        List <WebElement> listOfItemsOnPage = driver.findElements(By.cssSelector("li.g"))
        System.out.println("Number of results are " + listOfItemsOnPage.size())

        Assert.assertEquals(listOfItemsOnPage.size(), 10, "Results are not 10")
    }

    @Test
    void CheckThatGoogleSignHas10Letters(){
        driver.get("http://www.google.com")

        WebElement searchInput = driver.findElement(By.id("gbqfq"))
        searchInput.sendKeys("InteliJ IDEA")
        searchInput.submit()

        (new WebDriverWait(driver, variableForWaiter)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.csb.gbil.ch")))
        List<WebElement> listOfLettersDisplayedOnPage = driver.findElements(By.cssSelector("span.csb.gbil.ch"))

        System.out.println("Number of letters are " + listOfLettersDisplayedOnPage.size())

        Assert.assertEquals(listOfLettersDisplayedOnPage.size(),10, "Not 10 letters")
    }

    @Test
    void TestingPaginationAfterSearch(){
        driver.get("http://www.google.com")

        WebElement searchInput = driver.findElement(By.id("gbqfq"))
        searchInput.sendKeys("InteliJ IDEA")
        searchInput.submit()

        (new WebDriverWait(driver, variableForWaiter)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table[id='nav']")))
        List<WebElement> listNumberOfPages = driver.findElements(By.cssSelector("span.csb.gbil.ch"))
        int numberOfPages = listNumberOfPages.size()
        System.out.println("Number of pages " + listNumberOfPages.size())

        assertTrue(numberOfPages>=10,"Number of pages is less than 10" )
    }

    @AfterTest
    void closeBrowser() {
        driver.quit()
    }

}
