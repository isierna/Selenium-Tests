package ua.irena.playground.pages.mailru

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.Select
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader
import ua.irena.playground.pages.AbstractPage
import ua.irena.playground.utils.Helpers

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
import static org.openqa.selenium.By.cssSelector

/**
 * Created by isierna on 3/3/2015.
 */
class MailruRegistrationPage extends AbstractPage {
    @FindBy(css = '#man1')
    WebElement toggleMale

    @FindBy(css = 'button.btn.btn_signup.js-submit')
    WebElement submitButton

    @FindBy(css = 'button.btn.btn.stylish.btn_main.confirm-ok')
    WebElement captchaPopup

    @FindBy(css = 'div.vmi.tac.mb14.t0.vt.qc-firstname-row input')
    WebElement userName

    @FindBy(css = 'div.vmi.tac.mb14.t0.vt.qc-lastname-row input')
    WebElement userSurname

    @FindBy(css = 'div.pRel.vmi.tac.mb14.t0.vt.login-field.qc-login-row input')
    WebElement emailAddress

    @FindBy(css = 'div.vmi.tac.mb14.t0.vt.qc-pass-row input')
    WebElement password

    @FindBy(css = 'div.vmi.tac.mb34.t0.qc-passverify-row input')
    WebElement confirmationPassword

    MailruRegistrationPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void at() {
        Helpers.waitUntil(presenceOfElementLocated(cssSelector('span[class="sig2"]')))
    }

    public void populateInputs() {
        userName.sendKeys(generateRandomString())
        userSurname.sendKeys(generateRandomString())
        emailAddress.sendKeys(generateRandomString())
        String pass = generateRandomString() + generateRandomNumber()
        password.sendKeys(pass)
        confirmationPassword.sendKeys(pass)
    }

    public static String generateRandomString() {
        RandomStringUtils randomObject = new RandomStringUtils()
        randomObject.randomAlphabetic(7)
    }

    public static String generateRandomNumber() {
        RandomStringUtils randomObject = new RandomStringUtils()
        randomObject.randomNumeric(3)
    }

    public static setBirthDate() {
        Select dateDropDown = new Select(Helpers.getElementByCssSelector("select.days.mt0.mb0.qc-select-day"))
        Select monthDropDown = new Select(Helpers.getElementByCssSelector("select.fll.months.mt0.mb0.qc-select-month"))
        Select yearDropDown = new Select(Helpers.getElementByCssSelector("select.flr.years.mt0.mb0.qc-select-year"))
        dateDropDown.selectByIndex(1)
        monthDropDown.selectByIndex(1)
        yearDropDown.selectByIndex(25)
    }
}

