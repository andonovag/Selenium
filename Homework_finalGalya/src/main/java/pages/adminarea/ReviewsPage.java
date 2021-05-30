package pages.adminarea;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Browser;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReviewsPage {


    /**
     * This method searches a review by author and clicks on Action Button in Review to edit review
     * @param author the author of the review
     */
    public static void editReview(String author) {
        WebElement reviewList = Browser.driver.findElement(By.id("form-review"));
        if (reviewList.getText().contains(author)) {
            WebElement checkBox = Browser.driver.findElement(By.xpath("//td[following-sibling::td[contains(.,'andonovag')]]/input"));

            if (!checkBox.isSelected())
                checkBox.click();

            assertTrue(checkBox.isSelected());
            WebElement editReviewButton = Browser.driver.findElement(By.xpath("//td[preceding-sibling::td[contains(.,'andonovag')]]//a"));
            editReviewButton.click();
        }
    }

    /**
     * Asserts the heading in the Edit Review Page that it
     * equals the provided as parameter text
     * @param expectedEditReviewPageTitle the expected Edit Review Page title
     * @param messageOnTestFailure the message that will appear in test reports in case of failure
     */
    public static void verifyEditReviewPageTitle(String expectedEditReviewPageTitle, String messageOnTestFailure) {
        String actualEditReviewPageTitle = Browser.driver.findElement(By.cssSelector(".panel-heading h3")).getText();
        Assert.assertTrue(actualEditReviewPageTitle.contains(expectedEditReviewPageTitle), messageOnTestFailure);
    }

    /**
     * This method change review status as Enabled
     */
    public static void enabledStatusReview(){
        Select status = new Select(Browser.driver.findElement(By.id("input-status")));
        status.selectByVisibleText("Enabled");
    }

    /**
     * This method clicks Save Button after enabled review status
     */
    public static void saveReview() {
        WebElement saveReviewButton = Browser.driver.findElement(By.cssSelector(".btn.btn-primary"));
        saveReviewButton.click();
    }

    /**
     * Asserts the Success Modified message in the Review Page that it
     * equals the provided as parameter text
     * @param expectedReviewSuccessModifiedMessage the expected success message when we modify message
     * @param messageOnTestFailure the message that will appear in test reports in case of failure
     */
    public static void verifyReviewSuccessModifiedMessage(String expectedReviewSuccessModifiedMessage, String messageOnTestFailure) {
        String actualReviewSuccessModifiedMessage = Browser.driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertTrue(actualReviewSuccessModifiedMessage.contains(expectedReviewSuccessModifiedMessage), messageOnTestFailure);
    }

    /**
     * Verify that review is exist by text parameters
     * @param expectedAuthor the expected review author
     * @param expectedReview the expected review
     * @param messageOnTestFailure the message that will appear in test reports in case of failure
     */
    public static void verifyReviewExist(String expectedAuthor, String expectedReview, String messageOnTestFailure){
        String actualAuthor = Browser.driver.findElement(By.xpath("//td[contains(.,'andonovag')]")).getText();
        String actualReview = Browser.driver.findElement(By.xpath("//td[contains(.,'Excellent quality. I recommend it!')]")).getText();
        Assert.assertTrue(actualAuthor.contains(expectedAuthor), messageOnTestFailure);
        Assert.assertTrue(actualReview.contains(expectedReview), messageOnTestFailure);
    }
}
