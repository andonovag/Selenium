package pages.adminarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Browser;

public class AdminDashboard {

    static WebDriverWait wait = new WebDriverWait(Browser.driver, 10);

    /**
     * Asserts the heading in the Dashboard page that it
     * equals the provided as parameter text
     * @param expectedDashboardHeadingText the expected dashboard heading text
     * @param messageOnTestFailure         the message that will appear in test reports in case of failure
     */
    public static void verifyDashboardHeadingText(String expectedDashboardHeadingText, String messageOnTestFailure) {
        String actualDashboardHeadingText = Browser.driver.findElement(By.cssSelector("div#content h1")).getText();
        Assert.assertEquals(actualDashboardHeadingText, expectedDashboardHeadingText, messageOnTestFailure);
    }

    /**
     * This method clicks on Sales in the Dashboard main menu
     */
    public static void clickOnSalesMenu() {
        WebElement salesMenu = Browser.driver.findElement(By.id("menu-sale"));
        salesMenu.click();
    }

    /**
     * This method clicks on Gift Vouchers in the Dashboard Sales menu
     */
    public static void clickOnGiftVouchersMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#collapse4-3']")));
        WebElement giftVouchersMenu = Browser.driver.findElement(By.cssSelector("a[href='#collapse4-3']"));
        giftVouchersMenu.click();
    }

    /**
     * This method clicks on submenu Gift Vouchers in the Dashboard Sales menu and opens Gift Vouchers page
     */
    public static void clickOnGiftVouchersSubMenu() {
        WebElement giftVouchersSubMenu = Browser.driver.findElement(By.cssSelector("#collapse4-3 li:nth-of-type(1)"));
        giftVouchersSubMenu.click();

    }

    /**
     * This method clicks on Catalog in the Dashboard main menu
     */
    public static void clickOnCatalogMenu() {
        WebElement catalogMenu = Browser.driver.findElement(By.id("menu-catalog"));
        catalogMenu.click();
    }

    /**
     * This method clicks on Reviews in the Catalog menu
     */
    public static void clickOnReviewsInCatalogMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse1 li:nth-of-type(9)")));
        WebElement reviews = Browser.driver.findElement(By.cssSelector("#collapse1 li:nth-of-type(9)"));
        reviews.click();
    }
}
