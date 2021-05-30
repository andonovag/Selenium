package customerarea.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.AdminDashboard;
import pages.adminarea.AdminLogin;
import pages.adminarea.ReviewsPage;
import pages.customerarea.HomePage;
import pages.customerarea.IMacPage;
import pages.customerarea.MacPage;

public class ReviewTest extends BaseTest {

    @Test
    public void reviewTest(){
        HomePage.navigateHomePage();
        HomePage.clickOnDesktops();
        HomePage.clickOnMac();
        MacPage.verifyMacPageText("Mac","This is a bug");
        MacPage.clickIMac();
        IMacPage.verifyIMacPage("iMac","This is a bug");
        IMacPage.clickOnReviewsTab();
        IMacPage.verifyWriteReviewTab("Write a review","This is a bug");
        IMacPage.inputName("andonovag");
        IMacPage.writeReview("Excellent quality. I recommend it!");
        IMacPage.clickRating5();
        IMacPage.clickContinueButton();
        IMacPage.verifySuccessWriteReviewMessage("Thank you for your review. It has been submitted to the webmaster for approval.","This is a bug");
        AdminLogin.navigateAdminLoginPage();
        AdminLogin.loginAsAdmin("admin2","parola123!");
        AdminDashboard.verifyDashboardHeadingText("Dashboard","There is a bug");
        AdminDashboard.clickOnCatalogMenu();
        AdminDashboard.clickOnReviewsInCatalogMenu();
        ReviewsPage.editReview("andonovag");
        ReviewsPage.verifyEditReviewPageTitle("Edit Review","There is a bug");
        ReviewsPage.enabledStatusReview();
        ReviewsPage.saveReview();
        ReviewsPage.verifyReviewSuccessModifiedMessage("Success: You have modified reviews!", "There is a bug");
        HomePage.navigateHomePage();
        HomePage.clickOnDesktops();
        HomePage.clickOnMac();
        MacPage.verifyMacPageText("Mac","This is a bug");
        MacPage.clickIMac();
        IMacPage.verifyIMacPage("iMac","This is a bug");
        IMacPage.clickOnReviewsTab();
        IMacPage.verifyWriteReviewTab("Write a review","This is a bug");
        ReviewsPage.verifyReviewExist("andonovag", "Excellent quality. I recommend it!","This is a bug");
    }

}
