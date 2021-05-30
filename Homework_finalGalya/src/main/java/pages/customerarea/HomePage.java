package pages.customerarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

public class HomePage {
    static WebDriverWait wait = new WebDriverWait(Browser.driver, 10);

    /**
     * Invoking this method will navigate you to the customer area of the project
     */
    public static void navigateHomePage() {
        Browser.driver.get("http://shop.pragmatic.bg");
    }

    /**
     * This method clicks on Desktops in Navigation Bar on Home Page
     */
    public static void clickOnDesktops(){
        WebElement desktopsDropDown = Browser.driver.findElement(By.cssSelector(".dropdown:nth-of-type(1)"));
        desktopsDropDown.click();
    }

    /**
     * This method clicks on Mac in Desktops drop down menu
     */
    public static void clickOnMac(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown:nth-of-type(1) li:nth-of-type(2)")));
        WebElement desktops = Browser.driver.findElement(By.cssSelector(".dropdown:nth-of-type(1) li:nth-of-type(2)"));
        desktops.click();
    }
}
