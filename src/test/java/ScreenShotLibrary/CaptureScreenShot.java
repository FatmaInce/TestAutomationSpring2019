package ScreenShotLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.SeleniumUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CaptureScreenShot {
    WebDriver driver;
    String userNameLocator="//input[@id='login']";
    String passwordLocator = "//input[@id='password']";
    String LoginLocator="//button[@class='btn btn-primary']";
    @Test
    public void takeScreenshot() throws IOException {
        WebDriverManager.chromedriver().setup();
        //here used interface element to call chrome
        driver=new ChromeDriver();
        //I insert implicitly wait in order to handle all kind of the NoSuchElementFound exceptions
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Here I used to maximize method to Maximize the opening website
        driver.manage().window().maximize();
        //here send the web adress link
        driver.get("http://34.220.250.213/web/login");
        WebElement usernameField = driver.findElement(By.xpath(userNameLocator));
        //Put value into the username input box
        usernameField.sendKeys("Learning to take the screenShot");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password input box
        passwordField.sendKeys("eventscrmmanager");
        // wait for 2 seconds
        SeleniumUtils.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(LoginLocator)).submit();
        SeleniumUtils.waitPlease(2);


        TakesScreenshot file=(TakesScreenshot)driver;//TakeScreenshot is an interface and to use the webDriver classes properties we have to cast it
        File source=file.getScreenshotAs(OutputType.FILE);//file is a class source that converts the screenshot into file
        String name="Brite ERP";

        FileUtils.copyFile(source,new File("C:\\Users\\Fatma Ince\\IdeaProjects\\TestAutomationSpring2019\\src\\test\\java\\ScreenShotLibrary" + name + ".jpg"));
        //./ScreenShotLibrary/
       // "C:/UsersFatma Ince/IdeaProjects/TestAutomationSpring2019/src/test/java/ScreenShotLibrary";






    }
}
