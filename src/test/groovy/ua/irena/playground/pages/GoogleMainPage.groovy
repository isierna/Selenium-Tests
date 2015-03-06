package ua.irena.playground.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader
import ua.irena.playground.utils.Helpers

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by irena on 2/3/15.
 */
class GoogleMainPage extends AbstractPage {
    final static String SEARCH_INPUT_SELECTOR = 'input[name="q"]'


    @FindBy(css = GoogleMainPage.SEARCH_INPUT_SELECTOR)
    WebElement searchInput

    GoogleMainPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void go() {
        driver.get("http://www.google.com")
        at()
    }

    @Override
    public void at() {
        Helpers.waitUntil presenceOfElementLocated(cssSelector(SEARCH_INPUT_SELECTOR))
    }
}

