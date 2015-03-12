package ua.irena.playground.pages.mailru
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader
import ua.irena.playground.pages.AbstractPage

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by isierna on 3/2/2015.
 */
class MailruHomePage extends AbstractPage {
    final static String LINK_TO_MAIL_REGISTRATION_SELECTOR = 'a.mailbox__register__link'

    @FindBy(css = MailruHomePage.LINK_TO_MAIL_REGISTRATION_SELECTOR)
    WebElement linkToMailRegistrationPage

    MailruHomePage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void go() {
        driver.get("https://mail.ru/")
        at()
    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector(LINK_TO_MAIL_REGISTRATION_SELECTOR)))
    }
}

