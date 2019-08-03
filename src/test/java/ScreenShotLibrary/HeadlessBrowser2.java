package ScreenShotLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.SeleniumUtils;

import java.io.File;

public class HeadlessBrowser2 {

    public static void main(String[] args) throws Exception {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver();

        //with Firefox
        // WebDriverManager.firefoxdriver().setup();
        // FirefoxOptions opt=new FirefoxOptions();
        //opt.addArguments("headless");
        // driver=new FirefoxDriver();

        String userNameLocator="//input[@id='login']";
        String passwordLocator = "//input[@id='password']";
        String LoginLocator="//button[@class='btn btn-primary']";
        driver.get("http://34.220.250.213/web/login");
        System.out.println(driver.getTitle());
        WebElement usernameField = driver.findElement(By.xpath(userNameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("eventscrmmanager60@info.com");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("eventscrmmanager");
        // wait for 2 seconds
        SeleniumUtils.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(LoginLocator)).submit();
        SeleniumUtils.waitPlease(2);
        System.out.println(driver.getTitle());

        //taking screenshot

        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        String dest="./ScreenShotLibrary/";
        File destination= new File(dest);
        FileUtils.copyFile(source,destination);
        System.out.println("screenshot is taken...");

       // SCUtilities.captureScreenShot(driver,HeadlessBrowser);
    }

    }

