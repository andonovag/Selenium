import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Takeaway {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\GALYA\\QAC20\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.takeaway.com");
    }


    @Test
    public void search() {
        WebElement locationField = driver.findElement(By.id("imysearchstring"));
        locationField.sendKeys("Тракия, Пловдив");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iautoCompleteDropDownContent")));

        WebElement showRestaurants = driver.findElement(By.id("submit_deliveryarea"));
        showRestaurants.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("irestaurantsearchstring-middle")));

        WebElement searchRestaurants = driver.findElement(By.id("irestaurantsearchstring-middle"));
        searchRestaurants.sendKeys("Jagerhof");


//        WebElement restaurant = utils.WaitTool.waitForElementPresent(driver,By.id("#irestaurantN1NO73Q"),10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("#irestaurantN1NO73Q")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#irestaurantN1NO73Q")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".restaurantname a[href='/bg/menu/jagerhofyegerhof']")));
        WebElement restaurant = driver.findElement(By.id("#irestaurantN1NO73Q"));
//        WebElement restaurant = driver.findElement(By.cssSelector(".restaurantname a[href='/bg/menu/jagerhofyegerhof']"));
        restaurant.click();

//        assertTrue(restaurant.getText().contains("Jagerhof"));

    }

    //    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
