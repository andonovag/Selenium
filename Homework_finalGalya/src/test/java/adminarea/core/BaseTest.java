package adminarea.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest {
    /**
     * This method opens Chrome browser
     */
    @BeforeMethod
    public void setup() {
        Browser.setup();
    }

    /**
     * This method closes the opened browser
     */
    @AfterMethod
    public void quit() {
        Browser.quit();
    }
}
