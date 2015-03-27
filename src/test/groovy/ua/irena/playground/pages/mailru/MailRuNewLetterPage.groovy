package ua.irena.playground.pages.mailru

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader
import ua.irena.playground.pages.AbstractPage

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
*  Created by isierna on 3/27/2015.
*/
class MailRuNewLetterPage extends AbstractPage{
    final static SEND_BUTTON = 'div[data-name = "send"]'

    @FindBy(css = 'textarea[data-original-name="To"]')
    WebElement emailToAddress

    @FindBy(css = 'input[name="Subject"]')
    WebElement emailSubject

    @FindBy(css = 'iframe[id^=compose_]')
    WebElement iFrame

    @FindBy(css = 'div[data-name = "send"]')
    WebElement sendButton

    MailRuNewLetterPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector(SEND_BUTTON)))
    }

    public void typeMessage(String greeting, String body) {
        driver.switchTo().frame(iFrame)
        WebElement emailBody = driver.findElement(By.tagName('body'))
        emailBody.sendKeys(greeting + "\n" + "\n" + body)
        driver.switchTo().defaultContent()
    }
}
