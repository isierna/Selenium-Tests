package ua.irena.playground.pages.mailru

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader
import ua.irena.playground.pages.AbstractPage

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader

/**
 * Created by isierna on 3/2/2015.
 */
class MailruHomePage extends AbstractPage{

    @Override
    public void go(){
        driver.get("https://mail.ru/")
        at()
    }

    @Override
    public void at(){
        waitUntil(presenceOfElementLocated(cssSelector('a.mailbox__register__link')))
    }
}
