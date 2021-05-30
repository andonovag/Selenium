package pages.customerarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Browser;

public class MacPage {

    /**
     * Verify that the Mac page is opened
     * @param expectedMacPageText the expected Mac page title text
     * @param messageOnTestFailure the message that will appear in test reports in case of failure
     */
    public static void verifyMacPageText(String expectedMacPageText, String messageOnTestFailure) {
        String actualMacPageText = Browser.driver.findElement(By.xpath("//h2[contains(text(),'Mac')]")).getText();
        Assert.assertEquals(actualMacPageText, expectedMacPageText, messageOnTestFailure);
    }

    /**
     * This method clicks on iMac as a product in the Mac page
     */
    public static void clickIMac(){
        WebElement iMac = Browser.driver.findElement(By.cssSelector(".caption a"));
        iMac.click();
    }
}
