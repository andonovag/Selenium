import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class LoginTest {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\GALYA\\QAC20\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/admin");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login() {
        WebElement username = driver.findElement(By.id("input-username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123!");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement message;
        message = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
        String messageText = message.getText();
        Assert.assertEquals(messageText, "Milen Strahinski", "This will appear if expected and actual are not the same");
    }
}