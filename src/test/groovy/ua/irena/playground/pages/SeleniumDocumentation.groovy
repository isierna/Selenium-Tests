package ua.irena.playground.pages

import org.openqa.selenium.WebElement
import ua.irena.playground.utils.Helpers

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs


/**
 * Created by irena on 2/9/15.
 */
class SeleniumDocumentation extends AbstractPage{
    @Override
    public void at() {
        Helpers.waitUntil(titleIs("Selenium Documentation — Selenium Documentation"))
    }

    public static WebElement getJavaButton() {
        Helpers.waitUntil(presenceOfElementLocated(cssSelector('input[type="image"][value="java"]')))
    }

    public static void selectingJavaLanguageOnlyIfNotSelected() {
        String srcValueJavaButton = getJavaButton().getAttribute("src")
        if (srcValueJavaButton == "http://www.seleniumhq.org/images/icons/java.png") {
            javaButton.click()
        }
    }

}
