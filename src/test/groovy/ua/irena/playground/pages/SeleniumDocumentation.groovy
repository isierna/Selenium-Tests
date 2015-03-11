package ua.irena.playground.pages
import org.openqa.selenium.WebElement

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs
/**
 * Created by irena on 2/9/15.
 */
class SeleniumDocumentation extends AbstractPage {
    @Override
    public void at() {
        waitUntil(titleIs("Selenium Documentation — Selenium Documentation"), driver)
    }

    public static void selectingJavaLanguageOnlyIfNotSelected() {
        WebElement javaButton = waitUntil(presenceOfElementLocated(cssSelector('input[type="image"][value="java"]')), driver)
        String srcValueJavaButton = javaButton.getAttribute("src")
        if (srcValueJavaButton == "http://www.seleniumhq.org/images/icons/java.png") {
            javaButton.click()
        }
    }

}
