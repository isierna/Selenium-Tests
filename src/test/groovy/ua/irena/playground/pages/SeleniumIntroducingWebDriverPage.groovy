package ua.irena.playground.pages
import org.openqa.selenium.By
import ua.irena.playground.utils.Helpers

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
/**
 * Created by isierna on 2/24/2015.
 */
class SeleniumIntroducingWebDriverPage extends AbstractPage {

    @Override
    public void at() {
        Helpers.waitUntil(presenceOfElementLocated(By.cssSelector("#introducing-webdriver")))
    }
}
