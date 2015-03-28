package ua.irena.playground.pages.mailru

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.Select
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader
import ua.irena.playground.pages.AbstractPage

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
*  Created by isierna on 3/3/2015.
*/
class MailruRegistrationPage extends AbstractPage {
    @FindBy(css = '#man1')
    WebElement toggleMale

    @FindBy(css = 'button.btn.btn_signup.js-submit')
    WebElement submitButton

    @FindBy(css = 'div.vmi.tac.mb14.t0.vt.qc-firstname-row input')
    WebElement firstName

    @FindBy(css = 'div.vmi.tac.mb14.t0.vt.qc-lastname-row input')
    WebElement lastName

    @FindBy(css = 'div.pRel.vmi.tac.mb14.t0.vt.login-field.qc-login-row input')
    WebElement login

    @FindBy(css = 'div.vmi.tac.mb14.t0.vt.qc-pass-row input')
    WebElement password

    @FindBy(css = 'div.vmi.tac.mb34.t0.qc-passverify-row input')
    WebElement confirmationPassword

    MailruRegistrationPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector('span[class="sig2"]')))
    }

    public static void setBirthDate(String day, String month, String year) {
        Select dateDropDown = new Select(driver.findElement(cssSelector("select.days.mt0.mb0.qc-select-day")))
        Select monthDropDown = new Select(driver.findElement(cssSelector("select.fll.months.mt0.mb0.qc-select-month")))
        Select yearDropDown = new Select(driver.findElement(cssSelector("select.flr.years.mt0.mb0.qc-select-year")))
        dateDropDown.selectByVisibleText(day)
        monthDropDown.selectByVisibleText(month)
        yearDropDown.selectByVisibleText(year)
    }

    public WebElement assertPopUpPresent() {
        waitUntil(presenceOfElementLocated(cssSelector("button.btn.btn_stylish.btn_main.confirm-ok")))
    }
}

