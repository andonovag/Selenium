package adminarea.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.AdminDashboard;
import pages.adminarea.AdminLogin;
import pages.adminarea.GiftVouchersPage;

public class CreateGiftVoucher extends BaseTest {


    @Test
    public void successfulCreateGiftVoucher() {
        AdminLogin.navigateAdminLoginPage();
        AdminLogin.loginAsAdmin("admin2", "parola123!");
        AdminDashboard.verifyDashboardHeadingText("Dashboard", "There is a bug");
        AdminDashboard.clickOnSalesMenu();
        AdminDashboard.clickOnGiftVouchersMenu();
        AdminDashboard.clickOnGiftVouchersSubMenu();
        GiftVouchersPage.verifyGiftVouchersPageHeadingText("Gift Vouchers", "There is a bug");
        GiftVouchersPage.checkDeleteFORYOU50Code();
        GiftVouchersPage.clickOnAddNewGiftVoucher();
        GiftVouchersPage.inputCodeGiftVoucher("FORYOU50");
        GiftVouchersPage.inputFromName("Galya Uzunova");
        GiftVouchersPage.inputFromEmail("admin2@adm.bg");
        GiftVouchersPage.inputToName("Daniel Uzunov");
        GiftVouchersPage.inputToEmail("dani2@dan.bg");
        GiftVouchersPage.inputAmount(50);
        GiftVouchersPage.saveVoucherGift();
        GiftVouchersPage.verifyGiftVouchersSuccessModifiedMessage("Success: You have modified vouchers!","There is a bug");
        GiftVouchersPage.verifyGiftVoucherExist("FORYOU50","There is a bug");
    }

}
