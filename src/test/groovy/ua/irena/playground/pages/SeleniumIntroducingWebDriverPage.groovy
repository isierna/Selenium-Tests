package ua.irena.playground.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 * Created by isierna on 2/24/2015.
 */
class SeleniumIntroducingWebDriverPage extends AbstractPage{

    @Override
    public void at(){
        waitUntil(presenceOfElementLocated(By.xpath("//*[@id=\"introducing-webdriver\"]/h2/text()")))
    }

    public static WebElement text(){
        presenceOfElementLocated(By.tagName("body"))
    }
}
