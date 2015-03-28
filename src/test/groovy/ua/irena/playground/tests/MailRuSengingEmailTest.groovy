package ua.irena.playground.tests

import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import ua.irena.playground.pages.mailru.*

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement

/**
 *  Created by isierna on 3/27/2015.
 */
class MailRuSengingEmailTest extends AbstractTest {
    MailruHomePage homePage
    MailRuInboxPage inboxPage
    MailRuNewLetterPage newLetterPage
    MailRuConfirmationPage confirmationPage
    MailRuReceivedLetterPage receivedLetterPage

    @BeforeMethod
    public void openHomePage() {
        homePage = new MailruHomePage()
        homePage.go()
    }

    @AfterMethod
    public void openBlankPage() {
        driver.get("about:blank")
    }

    @Test
    void emailSending() {
        homePage.login.sendKeys("siernai")
        homePage.password.sendKeys("123456zz")
        homePage.loginButton.click()

        inboxPage = new MailRuInboxPage()
        inboxPage.at()
        inboxPage.newLetterButton.click()

        newLetterPage = new MailRuNewLetterPage()
        newLetterPage.at()
        newLetterPage.emailToAddress.sendKeys("receive11@mail.ru")
        newLetterPage.emailSubject.sendKeys("Test Subject")
        newLetterPage.typeMessage("Hi Sandy ,", "Have a nice day!!!")
        newLetterPage.sendButton.click()

        confirmationPage = new MailRuConfirmationPage()
        confirmationPage.at()
        confirmationPage.logoutButton.click()

        homePage = new MailruHomePage()
        homePage.at()
        homePage.login.clear()
        homePage.login.sendKeys("receive11")
        homePage.password.sendKeys("123456zz")
        homePage.loginButton.click()

        inboxPage = new MailRuInboxPage()
        inboxPage.at()
        waitUntil(textToBePresentInElement(inboxPage.firstMessage, "Test Subject"))
        inboxPage.firstMessage.click()

        receivedLetterPage = new MailRuReceivedLetterPage()
        receivedLetterPage.at()
        waitUntil(textToBePresentInElement(receivedLetterPage.letterBody, "Have a nice day!!!"))
    }
}
