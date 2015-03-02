package ua.irena.playground.tests

import org.junit.Test
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import ua.irena.playground.pages.mailru.MailruHomePage

/**
 * Created by isierna on 2/27/2015.
 */
class MailRuRegistration extends AbstractTest {

    MailruHomePage page

    @BeforeMethod
    public void openMainPage() {
        page = new MailruHomePage()
        page.go()
    }

    @AfterMethod
    public void openBlankPage() {
        driver.get("about:blank")
    }

    @Test
    void print() {
        System.out.println("working")
    }
}
