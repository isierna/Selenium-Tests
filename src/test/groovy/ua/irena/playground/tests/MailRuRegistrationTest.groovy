package ua.irena.playground.tests

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
        def registrationLink = page.getRegistrationLink()
        registrationLink.click()

        registrationPage = new MailruRegistrationPage()
        registrationPage.at()

        registrationPage.populateField(0, registrationPage.randomString)
        registrationPage.populateField(1, registrationPage.randomString)

        registrationPage.setBirthDate(registrationPage.date, 1)
        registrationPage.setBirthDate(registrationPage.month, 1)
        registrationPage.setBirthDate(registrationPage.year, 25)

        registrationPage.getElementByCssSelector(registrationPage.toggleMaleGenderSelector).click()

        registrationPage.populateField(3, "cheburawka" + registrationPage.randomNumber)
        registrationPage.populateField(3, "ddd")
        registrationPage.populateField(4, "&&&" + registrationPage.randomString)
        registrationPage.populateField(5, "&&&" + registrationPage.randomString)

        registrationPage.getSubmitButton().submit()

        assertTrue(registrationPage.getCaptchaPopup(), "Pop-up with captcha is not shown")
    }
}
