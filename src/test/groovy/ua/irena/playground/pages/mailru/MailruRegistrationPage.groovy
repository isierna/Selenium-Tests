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
    final static String TOGGLE_MALE_GENDER_SELECTOR = '#man1'
    final static String SUBMIT_BUTTON_SELECTOR = 'button.btn.btn_signup.js-submit'
    final static String CAPTCHA_POPUP_SELECTOR = 'button.btn.btn.stylish.btn_main.confirm-ok"'
    final static String NAME_SELECTOR = 'div.vmi.tac.mb14.t0.vt.qc-firstname-row input'
    final static String SURNAME_SELECTOR = 'div.vmi.tac.mb14.t0.vt.qc-lastname-row input'
    final static String EMAIL_ADDRESS = 'div.pRel.vmi.tac.mb14.t0.vt.login-field.qc-login-row input'
    final static String PASSWORD = 'div.vmi.tac.mb14.t0.vt.qc-pass-row input'
    final static String CONFIRMATION_PASSWORD ='div.vmi.tac.mb34.t0.qc-passverify-row input'

    @FindBy(css = MailruRegistrationPage.TOGGLE_MALE_GENDER_SELECTOR)
    WebElement toggleMale

    @FindBy(css = MailruRegistrationPage.SUBMIT_BUTTON_SELECTOR)
    WebElement submitButton

    @FindBy(css = MailruRegistrationPage.CAPTCHA_POPUP_SELECTOR)
    WebElement captchaPopup

    @FindBy(css = MailruRegistrationPage.NAME_SELECTOR)
    WebElement userName

    @FindBy(css = MailruRegistrationPage.SURNAME_SELECTOR)
    WebElement userSurname

    @FindBy(css = MailruRegistrationPage.EMAIL_ADDRESS)
    WebElement emailAddress

    @FindBy(css = MailruRegistrationPage.PASSWORD)
    WebElement password

    @FindBy(css = MailruRegistrationPage.CONFIRMATION_PASSWORD)
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

