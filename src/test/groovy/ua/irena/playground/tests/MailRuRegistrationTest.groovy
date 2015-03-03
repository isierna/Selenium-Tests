package ua.irena.playground.tests

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.WebElement
import org.testng.annotations.Test
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import ua.irena.playground.pages.mailru.MailruHomePage
import ua.irena.playground.pages.mailru.MailruRegistrationPage

import static org.testng.Assert.assertTrue

/**
 * Created by isierna on 2/27/2015.
 */
class MailRuRegistrationTest extends AbstractTest {

    MailruHomePage page
    MailruRegistrationPage registrationPage

    @BeforeMethod
    public void openMainPage() {
        page = new MailruHomePage()
        page.go()
    }

    @AfterMethod
    public void openBlankPage() {
        driver.get("about:blank")
    }

    @Test
    void emailRegistration() {
        def registrationLink = page.getLinkByCssSelector('a.mailbox__register__link')
        registrationLink.click()

        registrationPage = new MailruRegistrationPage()
        registrationPage.at()


        RandomStringUtils randomObject = new RandomStringUtils()
        String randomString = randomObject.randomAlphabetic(7)
        String randomNumber = randomObject.randomNumeric(3)


        List<WebElement> listOfFields = registrationPage.getListOfFields()
        listOfFields.size()
        listOfFields[0].sendKeys(randomString)
        listOfFields[1].sendKeys(randomString)

        registrationPage.setBirthDate("select.days.mt0.mb0.qc-select-day", 1) //date
        registrationPage.setBirthDate("select.fll.months.mt0.mb0.qc-select-month", 1) //month
        registrationPage.setBirthDate("select.flr.years.mt0.mb0.qc-select-year", 25) //year

        registrationPage.getElementByCssSelector('#man1').click()

        listOfFields[3].sendKeys("cheburawka" + randomNumber)
        listOfFields[3].sendKeys("ddd")
        listOfFields[4].sendKeys("&&&" + randomString)
        listOfFields[5].sendKeys("&&&" + randomString)

        registrationPage.getElementByCssSelector('button.btn.btn_signup.js-submit').submit()

        Boolean popUpShown = registrationPage.getElementByCssSelector('div.popup__box')
        assertTrue(popUpShown, "Pop-up with captcha is not shown")
    }
}
