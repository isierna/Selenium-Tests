package ua.irena.playground.pages.mailru

import org.apache.commons.lang.RandomStringUtils
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
    String dateSelector = "select.days.mt0.mb0.qc-select-day"
    String monthSelector = "select.fll.months.mt0.mb0.qc-select-month"
    String yearSelector = "select.flr.years.mt0.mb0.qc-select-year"
    String toggleMaleGenderSelector = '#man1'
    static String submitButtonSelector = 'button.btn.btn_signup.js-submit'
    static String captchaPopupSelector = 'div.popup__box'
    String randomString = generateRandomString()
    String randomNumber = generateRandomNumber()

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector('span[class="sig2"]')))
    }

    public static List<WebElement> getListOfFields() {
        waitUntil(presenceOfAllElementsLocatedBy(cssSelector('.inPut')))
    }

    List<WebElement> listOfFields = getListOfFields()


    public static String generateRandomString() {
        RandomStringUtils randomObject = new RandomStringUtils()

        randomObject.randomAlphabetic(7)
    }

    public static String generateRandomNumber() {
        RandomStringUtils randomObject = new RandomStringUtils()

        randomObject.randomNumeric(3)
    }

    public populateField(int index, String randomValue) {
        listOfFields[index].sendKeys(randomValue)
    }


    public static setBirthDate(String selector, int index) {
        WebElement valueBirth = getElementByCssSelector(selector)

        Select dropDown = new Select(valueBirth)
        dropDown.selectByIndex(index)
    }

    public static WebElement getSubmitButton() {
        getLinkByCssSelector(submitButtonSelector)
    }

    public static Boolean getCaptchaPopup() {
        getElementByCssSelector(captchaPopupSelector)
    }

}

