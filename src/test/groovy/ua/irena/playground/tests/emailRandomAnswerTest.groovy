package ua.irena.playground.tests

import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import ua.irena.playground.pages.mailru.*

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement
import static ua.irena.playground.utils.Helpers.generateRandomNumber

/**
 *  Created by isierna on 4/1/2015.
 */
class emailRandomAnswerTest extends AbstractTest {
    MailruHomePage homePage
    MailRuInboxPage inboxPage
    MailRuNewLetterPage newLetterPage
    MailRuConfirmationPage confirmationPage
    MailRuReceivedLetterPage receivedLetterPage

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
    void answerRandomEmail() {
        homePage.login.clear()
        homePage.login.sendKeys("siernai")
        homePage.password.sendKeys("123456zz")
        homePage.loginButton.click()

        inboxPage = new MailRuInboxPage()
        inboxPage.at()

        String randomNumber = generateRandomNumber()
        String testNumber
        int i

        for (i = 9; i > -1; i--) {
            inboxPage.newLetterButton.click()
            newLetterPage = new MailRuNewLetterPage()
            newLetterPage.at()
            newLetterPage.emailToAddress.sendKeys("receive11@mail.ru")
            testNumber = randomNumber
            newLetterPage.emailSubject.sendKeys("Message # " + testNumber + i)
            newLetterPage.typeMessage("Hi Sandy ,", "Have a nice day!!!")
            newLetterPage.sendButton.click()
            confirmationPage = new MailRuConfirmationPage()
            confirmationPage.at()
        }

        confirmationPage.logoutButton.click()

        homePage = new MailruHomePage()
        homePage.at()
        homePage.login.clear()
        homePage.login.sendKeys("receive11")
        homePage.password.sendKeys("123456zz")
        homePage.loginButton.click()

        inboxPage = new MailRuInboxPage()
        inboxPage.at()
        int index = inboxPage.clickOnRandomEmail(testNumber)

        receivedLetterPage = new MailRuReceivedLetterPage()
        receivedLetterPage.at()
        waitUntil(textToBePresentInElement(receivedLetterPage.letterBody, "Have a nice day!!!"))
        receivedLetterPage.replyButton.click()

        newLetterPage = new MailRuNewLetterPage()
        newLetterPage.at()
        newLetterPage.typeMessage("Hello Irena,", "Thanks for your email")
        newLetterPage.sendButton.click()

        confirmationPage = new MailRuConfirmationPage()
        confirmationPage.at()
        confirmationPage.logoutButton.click()

        homePage = new MailruHomePage()
        homePage.login.clear()
        homePage.login.sendKeys("siernai")
        homePage.password.sendKeys("123456zz")
        homePage.loginButton.click()

        inboxPage = new MailRuInboxPage()
        waitUntil(textToBePresentInElement(inboxPage.inboxBody, "Re: Message # " + testNumber + index))
    }
}
