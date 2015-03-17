package ua.irena.playground.tests

import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import ua.irena.playground.pages.mailru.MailruHomePage
import ua.irena.playground.pages.mailru.MailruRegistrationPage

import static ua.irena.playground.utils.Helpers.generateRandomNumber
import static ua.irena.playground.utils.Helpers.generateRandomString

/**
 * Created by isierna on 2/27/2015.
 */
class MailRuRegistrationTest extends AbstractTest {
    MailruHomePage homePage
    MailruRegistrationPage registrationPage

    @BeforeMethod
    public void openMainPage() {
        homePage = new MailruHomePage()
        homePage.go()
    }

    @AfterMethod
    public void openBlankPage() {
        driver.get("about:blank")
    }

    @Test
    void emailRegistration() {
        homePage.linkToMailRegistrationPage.click()

        registrationPage = new MailruRegistrationPage()
        registrationPage.at()

        registrationPage.firstName.sendKeys("Ira")
        registrationPage.lastName.sendKeys("Sierna")
        registrationPage.login.sendKeys(generateRandomString()+ generateRandomNumber())
        String password = generateRandomString() + generateRandomNumber()
        registrationPage.password.sendKeys(password)
        registrationPage.confirmationPassword.sendKeys(password)
        registrationPage.setBirthDate("1", "Май", "1991")
        registrationPage.toggleMale.click()

        registrationPage.submitButton.submit()
        registrationPage.assertPopUpPresent()
    }
}
