package ua.irena.playground.pages.mailru

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader
import ua.irena.playground.pages.AbstractPage

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 *  Created by isierna on 3/27/2015.
 */
class MailRuReceivedLetterPage extends AbstractPage {
    final static LETTER_BODY = 'div.b-letter__body'

    @FindBy(css = MailRuReceivedLetterPage.LETTER_BODY)
    WebElement letterBody

    @FindBy(css = 'a#PH_logoutLink')
    WebElement logoutButton

    @FindBy(css = 'div[data-name="reply"]')
    WebElement replyButton

    MailRuReceivedLetterPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector(LETTER_BODY)))
    }
}
