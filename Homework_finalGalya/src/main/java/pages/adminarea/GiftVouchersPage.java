package pages.adminarea;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Browser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;


public class GiftVouchersPage {

    /**
     * Asserts the heading in the Gift Voucher page that it
     * equals the provided as parameter text
     * @param expectedGiftVouchersPageHeadingText the expected Gift Vouchers Heading text
     * @param messageOnTestFailure                the message that will appear in test reports in case of failure
     */
    public static void verifyGiftVouchersPageHeadingText(String expectedGiftVouchersPageHeadingText, String messageOnTestFailure) {
        String actualGiftVouchersPageHeadingText = Browser.driver.findElement(By.cssSelector("div#content h1")).getText();
        Assert.assertEquals(actualGiftVouchersPageHeadingText, expectedGiftVouchersPageHeadingText, messageOnTestFailure);
    }

    /**
     * This method verify that Gift Voucher code not exist and clicks on Add new button
     */
    public static void clickOnAddNewGiftVoucher() {
        WebElement giftVoucherList = Browser.driver.findElement(By.cssSelector(".table.table-bordered"));
        if (!giftVoucherList.getText().contains("FORYOU50")) {
            WebElement newGiftVoucherButton = Browser.driver.findElement(By.cssSelector("div.pull-right a"));
            newGiftVoucherButton.click();
        }
    }

    /**
     * This method enters Gift Voucher Code in input field as a string parameter
     */
    public static void inputCodeGiftVoucher(String code) {
        WebElement codeField = Browser.driver.findElement(By.id("input-code"));
        codeField.sendKeys(code);
    }

    /**
     * This method checks if the Gift Voucher Code exists and removes it when exist
     */
    public static void checkDeleteFORYOU50Code() {
        WebElement giftVoucherList = Browser.driver.findElement(By.cssSelector(".table.table-bordered"));
        if (giftVoucherList.getText().contains("FORYOU50")) {
            WebElement checkBox = Browser.driver.findElement(By.xpath("//td[following-sibling::td[contains(.,'FORYOU50')]]/input"));

            if (!checkBox.isSelected())
                checkBox.click();

            assertTrue(checkBox.isSelected());

            Browser.driver.findElement(By.cssSelector(".btn.btn-danger")).click();

            Alert alert = Browser.driver.switchTo().alert();
            String textOnAlert = alert.getText();
            alert.accept();
            assertEquals(textOnAlert, "Are you sure?");

            String actualGiftVouchersSuccessModifiedMessage = Browser.driver.findElement(By.cssSelector(".alert.alert-success")).getText();
            Assert.assertTrue(actualGiftVouchersSuccessModifiedMessage.contains("Success: You have modified vouchers!"), "There is a bug");
        }
    }

    /**
     * This method verify that Gift Voucher exist by his code
     * @param code the Gift Voucher Code we are looking for
     * @param messageOnTestFailure the message that will appear in test reports in case of failure
     */
    public static void verifyGiftVoucherExist(String code, String messageOnTestFailure) {
        String giftVoucherList = Browser.driver.findElement(By.cssSelector(".table.table-bordered")).getText();
        Assert.assertTrue(giftVoucherList.contains(code), messageOnTestFailure);
    }


    /**
     * This method enters From Name in input field as a string parameter
     * @param fromName the name of person who sends Gift Voucher
     */
    public static void inputFromName(String fromName) {
        WebElement fromNameField = Browser.driver.findElement(By.id("input-from-name"));
        fromNameField.sendKeys(fromName);
    }

    /**
     * This method enters From Email in input field as a string parameter
     * @param email the email of person who sends Gift Voucher
     */
    public static void inputFromEmail(String email) {
        WebElement fromEmailField = Browser.driver.findElement(By.id("input-from-email"));
        fromEmailField.sendKeys(email);
    }

    /**
     * This method enters To Name in input field as a string parameter
     * @param toName the name of person who receives Gift Voucher
     */
    public static void inputToName(String toName) {
        WebElement toNameField = Browser.driver.findElement(By.id("input-to-name"));
        toNameField.sendKeys(toName);
    }

    /**
     * This method enters To Email in input field as a string parameter
     * @param toEmail the email of person who receives Gift Voucher
     */
    public static void inputToEmail(String toEmail) {
        WebElement toEmailField = Browser.driver.findElement(By.id("input-to-email"));
        toEmailField.sendKeys(toEmail);
    }

    /**
     * This method enters amount of dollars on the Gift voucher as integer parameter
     * @param amount the sum in dollars you would like to the Gift voucher
     */
    public static void inputAmount(Integer amount) {
        WebElement amountField = Browser.driver.findElement(By.id("input-amount"));
        amountField.sendKeys(String.valueOf(amount));
    }

    /**
     * This method saves added Gift Voucher
     */
    public static void saveVoucherGift() {
        WebElement saveVoucherGiftButton = Browser.driver.findElement(By.cssSelector(".btn.btn-primary"));
        saveVoucherGiftButton.click();
    }

    /**
     * Asserts the success message for modified voucher that it
     * equals the provided as parameter text
     * @param expectedGiftVouchersSuccessModifiedMessage the expected success message text
     * @param messageOnTestFailure                       the message that will appear in test reports in case of failure
     */
    public static void verifyGiftVouchersSuccessModifiedMessage(String expectedGiftVouchersSuccessModifiedMessage, String messageOnTestFailure) {
        String actualGiftVouchersSuccessModifiedMessage = Browser.driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertTrue(actualGiftVouchersSuccessModifiedMessage.contains(expectedGiftVouchersSuccessModifiedMessage), messageOnTestFailure);
    }


}
