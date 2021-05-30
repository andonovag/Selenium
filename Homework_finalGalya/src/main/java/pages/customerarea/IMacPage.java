package pages.customerarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Browser;

public class IMacPage {

    static WebDriverWait wait = new WebDriverWait(Browser.driver, 10);

    /**
     * Verify that iMac page is opened
     * @param expectedIMacPageText the expected iMac page title text
     * @param messageOnTestFailure the message that will appear in test reports in case of failure
     */
    public static void verifyIMacPage(String expectedIMacPageText, String messageOnTestFailure) {
        String actualIMacPageText = Browser.driver.findElement(By.xpath("//h1[contains(text(),'iMac')]")).getText();
        Assert.assertEquals(actualIMacPageText, expectedIMacPageText, messageOnTestFailure);
    }

    /**
     * This method clicks on Review Tab in the product page
     */
    public static void clickOnReviewsTab() {
        WebElement reviewsTab = Browser.driver.findElement(By.cssSelector("a[href='#tab-review']"));
        reviewsTab.click();
    }

    /**
     * Verify that we are on the Write Review tab in the product page
     * @param expectedWriteReviewTab the expected Write Review title
     * @param messageOnTestFailure the message that will appear in test reports in case of failure
     */
    public static void verifyWriteReviewTab(String expectedWriteReviewTab, String messageOnTestFailure) {
        String actualWriteReviewTab = Browser.driver.findElement(By.xpath("//h2[contains(text(),'Write a review')]")).getText();
        Assert.assertEquals(actualWriteReviewTab, expectedWriteReviewTab, messageOnTestFailure);
    }

    /**
     * This method inputs name in Your Name field on Write Review tab
     * @param name the name you would like to input
     */
    public static void inputName(String name) {
        WebElement yourName = Browser.driver.findElement(By.id("input-name"));
        yourName.sendKeys(name);
    }

    /**
     * This method inputs your review in Your Review field on Write Review tab
     * @param review the review you would like to write
     */
    public static void writeReview(String review){
        WebElement yourReview = Browser.driver.findElement(By.id("input-review"));
        yourReview.sendKeys(review);
    }

    /**
     * This method clicks on the last rating radio button
     */
    public static void clickRating5(){
        WebElement rating = Browser.driver.findElement(By.xpath("//input[contains(@name,'rating')][@value='5']"));
        rating.click();
    }

    /**
     * This method clicks on Continue button after you wrote a review
     */
    public static void clickContinueButton(){
        WebElement continueButton = Browser.driver.findElement(By.id("button-review"));
        continueButton.click();
    }

    /**
     * Asserts the Success Write Review Message after you wrote a review
     * @param expectedSuccessWriteReviewMessage the expected success message
     * @param messageOnTestFailure the message that will appear in test reports in case of failure
     */
    public static void verifySuccessWriteReviewMessage(String expectedSuccessWriteReviewMessage, String messageOnTestFailure){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success.alert-dismissible")));
        String actualSuccessWriteReviewMessage = Browser.driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        Assert.assertTrue(actualSuccessWriteReviewMessage.contains(expectedSuccessWriteReviewMessage),messageOnTestFailure);
    }
}
