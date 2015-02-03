import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
/**
 * Created by irena on 2/2/15.
 */
class ChangedParams {

    int variableForWaiter = 10


    WebElement waitUntil(String selectorVariable, WebDriver driver) {

        WebElement elementLinkText = (new WebDriverWait(driver, variableForWaiter)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selectorVariable)))

        return elementLinkText

    }

}
