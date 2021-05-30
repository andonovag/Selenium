import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TestDropdown {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\GALYA\\QAC20\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/admin");
    }


    @Test
    public void testDropdown() {
        WebElement username = driver.findElement(By.id("input-username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123!");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement sales = driver.findElement(By.xpath("//li[@id='menu-sale']//a[@href='#collapse4']"));
        sales.click();

        List<WebElement> currencyList= driver.findElements(By.id("collapse4"));
        for(WebElement currency:currencyList ){
            if(currency.getText().equals("Orders"))
                currency.click();
        }

        Select filter = new Select(driver.findElement(By.id("input-order-status")));
        assertFalse(filter.isMultiple());
        assertEquals(filter.getOptions().size(), 16);
        List<String> exp_options = Arrays.asList(new String[]{"", "Missing Orders", "Canceled",
                "Canceled Reversal", "Chargeback","Complete", "Denied", "Expired", "Failed", "Pending", "Processed", "Processing", "Refunded", "Reversed", "Shipped", "Voided"});
        List<String> act_options = new ArrayList<String>();
        for(WebElement option : filter.getOptions())
            act_options.add(option.getText());
        assertEquals(act_options.toArray(), exp_options.toArray());

        filter.selectByVisibleText("Missing Orders");
        assertEquals(filter.getFirstSelectedOption().getText(), "Missing Orders");
        filter.selectByVisibleText("Canceled");
        assertEquals(filter.getFirstSelectedOption().getText(), "Canceled");
        filter.selectByVisibleText("Canceled Reversal");
        assertEquals(filter.getFirstSelectedOption().getText(), "Canceled Reversal");
        filter.selectByVisibleText("Chargeback");
        assertEquals(filter.getFirstSelectedOption().getText(), "Chargeback");
        filter.selectByVisibleText("Complete");
        assertEquals(filter.getFirstSelectedOption().getText(), "Complete");
        filter.selectByVisibleText("Denied");
        assertEquals(filter.getFirstSelectedOption().getText(), "Denied");
        filter.selectByVisibleText("Expired");
        assertEquals(filter.getFirstSelectedOption().getText(), "Expired");
        filter.selectByVisibleText("Failed");
        assertEquals(filter.getFirstSelectedOption().getText(), "Failed");
        filter.selectByVisibleText("Pending");
        assertEquals(filter.getFirstSelectedOption().getText(), "Pending");
        filter.selectByVisibleText("Processed");
        assertEquals(filter.getFirstSelectedOption().getText(), "Processed");
        filter.selectByVisibleText("Processing");
        assertEquals(filter.getFirstSelectedOption().getText(), "Processing");
        filter.selectByVisibleText("Refunded");
        assertEquals(filter.getFirstSelectedOption().getText(), "Refunded");
        filter.selectByVisibleText("Reversed");
        assertEquals(filter.getFirstSelectedOption().getText(), "Reversed");
        filter.selectByVisibleText("Shipped");
        assertEquals(filter.getFirstSelectedOption().getText(), "Shipped");
        filter.selectByVisibleText("Voided");
        assertEquals(filter.getFirstSelectedOption().getText(), "Voided");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
