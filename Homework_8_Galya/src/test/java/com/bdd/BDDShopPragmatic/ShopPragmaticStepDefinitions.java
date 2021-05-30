package com.bdd.BDDShopPragmatic;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShopPragmaticStepDefinitions {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\GALYA\\QAC20\\SELENIUM\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }

    @Given("the admin is on Login Page")
    public void the_admni_is_on_Login_Page() {
        driver.get("http://shop.pragmatic.bg/admin");
    }

    @When("he enters {string} as username")
    public void heEntersAsUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("input-username"));
        usernameField.sendKeys(username);
    }

    @And("he enters {string} as password")
    public void heEntersAsPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys(password);
    }

    @And("he clicks on the Login button")
    public void heClickOnTheLoginButton() {
        WebElement loginButton = driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
    }

    @Then("ensure that admin login is successful and {string} is visible")
    public void ensureTheAdminIsLoginSuccessfulAndTextIsVisible(String Dashboard) {
        String actualDashboardText = driver.findElement(By.cssSelector("div#content h1")).getText();
        Assert.assertEquals(Dashboard, actualDashboardText);
    }

    @Then("ensure that admin login is not successful and {string} message is visible")
    public void ensureAdminLoginIsNotSuccessfulAndMessageIsVisible(String ErrorLoginMessage) {
        String actualErrorLoginMessage = driver.findElement(By.cssSelector(".alert-danger")).getText();
        Assert.assertTrue(actualErrorLoginMessage.contains(ErrorLoginMessage));
    }

    @When("he clicks on the Forgotten Password link")
    public void heClickOnTheForgottenPasswordLink() {
        driver.findElement(By.cssSelector(".help-block a")).click();
    }

    @Then("ensure that successful message {string} is visible")
    public void ensureThatMessageIsVisible(String SuccessfulMessageInForgottenPassword) {
        String actualSuccessfulMessageInForgottenPassword = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertTrue(actualSuccessfulMessageInForgottenPassword.contains(SuccessfulMessageInForgottenPassword));
    }

    @And("he enters {string} as e-mail address")
    public void heEntersAsEMailAddress(String emailAddress) {
        WebElement emailAddressField = driver.findElement(By.id("input-email"));
        emailAddressField.sendKeys(emailAddress);
    }

    @And("he clicks on the Reset button")
    public void heClicksOnTheResetButton() {
        WebElement resetButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        resetButton.click();
    }

    @And("he clicks on the Cancel button")
    public void heClicksOnTheCancelButton() {
        WebElement cancelButton = driver.findElement(By.cssSelector(".btn.btn-default"));
        cancelButton.click();
    }


    @Then("ensure that he is back on the Login Page and text {string} is visible")
    public void ensureThatHeIsBackOnTheLoginPageAndTextIsVisible(String adminPanelTitleText) {
        String actualAdminPanelTitleText = driver.findElement(By.cssSelector(".panel-title")).getText();
        Assert.assertEquals(adminPanelTitleText, actualAdminPanelTitleText);
    }

    @Then("ensure that unsuccessful message {string} is visible")
    public void ensureThatUnsuccessfulMessageIsVisible(String unsuccessfulMessageInForgottenPassword) {
        String actualUnsuccessfulMessageInForgottenPassword = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertTrue(actualUnsuccessfulMessageInForgottenPassword.contains(unsuccessfulMessageInForgottenPassword));
    }

    @And("he clicks on the Logout button")
    public void heClicksOnTheLogoutButton() {
        WebElement logoutButton = driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        logoutButton.click();
    }

    @And("ensure that he is on Forgotten Password Page and {string} text is visible")
    public void ensureThatHeIsOnForgottenPasswordPageAndTextIsVisible(String forgottenPasswordPagePanelTitle) {
        String actualForgottenPasswordPagePanelTitle = driver.findElement(By.cssSelector(".panel-title")).getText();
        Assert.assertTrue(actualForgottenPasswordPagePanelTitle.contains(forgottenPasswordPagePanelTitle));
    }
}
