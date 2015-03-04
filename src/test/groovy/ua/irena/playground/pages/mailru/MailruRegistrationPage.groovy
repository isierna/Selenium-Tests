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
    String dateSelector = "select.days.mt0.mb0.qc-select-day"
    String monthSelector = "select.fll.months.mt0.mb0.qc-select-month"
    String yearSelector = "select.flr.years.mt0.mb0.qc-select-year"
    String toggleMaleGenderSelector = '#man1'
    String submitButtonSelector = 'button.btn.btn_signup.js-submit'
    String captchaPopupSelector = 'div.popup__box'

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

