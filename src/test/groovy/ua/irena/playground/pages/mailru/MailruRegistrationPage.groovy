package ua.irena.playground.pages.mailru

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import ua.irena.playground.pages.AbstractPage

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
import static org.openqa.selenium.By.cssSelector

/**
 * Created by isierna on 3/3/2015.
 */
class MailruRegistrationPage extends AbstractPage {

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector('span[class="sig2"]')))
    }

    public static List<WebElement> getListOfFields() {
        waitUntil(presenceOfAllElementsLocatedBy(cssSelector('.inPut')))
    }


    public static setBirthDate(String selector, int index) {
        WebElement valueBirth = getElementByCssSelector(selector)

        Select dropDown = new Select(valueBirth)
        dropDown.selectByIndex(index)
    }

}

