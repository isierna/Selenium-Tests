package ua.irena.playground.pages.mailru


import org.openqa.selenium.WebElement

import ua.irena.playground.pages.AbstractPage

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated


/**
 * Created by isierna on 3/2/2015.
 */
class MailruHomePage extends AbstractPage {
    static String linkToMailRegistrationSelector = 'a.mailbox__register__link'

    @Override
    public void go() {
        driver.get("https://mail.ru/")
        at()
    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector('a.mailbox__register__link')))
    }

    public static WebElement getRegistrationLink() {
        getLinkByCssSelector(linkToMailRegistrationSelector)
    }
}
