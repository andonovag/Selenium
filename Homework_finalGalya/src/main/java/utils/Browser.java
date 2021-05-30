package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\GALYA\\QAC20\\SELENIUM\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void quit() {
        driver.quit();
    }
}
