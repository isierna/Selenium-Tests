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
        def registrationLink = page.getLinkByCssSelector(page.linkToMailRegistrationSelector)
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

        registrationPage.setBirthDate(registrationPage.dateSelector, 1) //dateSelector
        registrationPage.setBirthDate(registrationPage.monthSelector, 1) //monthSelector
        registrationPage.setBirthDate(registrationPage.yearSelector, 25) //yearSelector

        registrationPage.getElementByCssSelector(registrationPage.toggleMaleGenderSelector).click()

        listOfFields[3].sendKeys("cheburawka" + randomNumber)
        listOfFields[3].sendKeys("ddd")
        listOfFields[4].sendKeys("&&&" + randomString)
        listOfFields[5].sendKeys("&&&" + randomString)

        registrationPage.getElementByCssSelector(registrationPage.submitButtonSelector).submit()

        Boolean popUpShown = registrationPage.getElementByCssSelector(registrationPage.captchaPopupSelector)
        assertTrue(popUpShown, "Pop-up with captcha is not shown")
    }
}
