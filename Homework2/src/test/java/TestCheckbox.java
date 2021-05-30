import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestCheckbox {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\GALYA\\QAC20\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
    }

    @Test
    public void checkbox(){
        WebElement airbags = driver.findElement(By.xpath("//input[@value='Airbags']"));
        WebElement parkingSensor = driver.findElement(By.xpath("//input[@value='ParkingSensor']"));
        Actions box = new Actions(driver);
        box.moveToElement(airbags).click().build().perform();
        assertTrue(airbags.isSelected());
        box.moveToElement(parkingSensor).click().build().perform();
        assertTrue(parkingSensor.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
