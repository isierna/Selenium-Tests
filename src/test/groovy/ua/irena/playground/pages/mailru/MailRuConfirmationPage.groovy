package ua.irena.playground.pages.mailru

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader
import ua.irena.playground.pages.AbstractPage

import java.text.SimpleDateFormat

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
*  Created by isierna on 3/27/2015.
*/
class MailRuConfirmationPage extends AbstractPage {
    String timeMessageSent

    @FindBy(css = 'a#PH_logoutlink')
    WebElement logoutButton

    MailRuConfirmationPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector("div.message-sent__title")))

    }

    public void saveTimeSent() {
        Calendar timeNow = Calendar.getInstance()
        SimpleDateFormat<String> simpleDateFormat = new SimpleDateFormat<String>("HH:mm")
        this.timeMessageSent = simpleDateFormat.format(timeNow.getTime())
    }
}
