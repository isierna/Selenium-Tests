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
class MailRuInboxPage extends AbstractPage {
    @FindBy(css = 'a[data-name="compose"]')
    WebElement newLetterButton

    @FindBy(css = 'div.b-datalist__item:first-child a.js-href.b-datalist__item__link')
    WebElement firstMessage

    @FindBy(css = 'div.b-datalist__body')
    WebElement inboxBody

    MailRuInboxPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector('span.b-nav__item__text')), 20L)
    }

    public Integer clickOnRandomEmail(String testNumber) {
        ArrayList<WebElement> listOfEmails = driver.findElements(cssSelector('a[data-subject^="Message # ' + testNumber + '"]'))
        Random randomGenerator = new Random()

        int index = randomGenerator.nextInt(listOfEmails.size())
        WebElement randomEmail = listOfEmails.get(index)
        randomEmail.click()

        return index
    }
}

