package day13_actions_jsexecuter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterTests {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void jsExecuterTest1(){
        driver.get("http://practice.cybertekschool.com/");
        // we want to run some javascript code
        //so, we have to use JavascriptExecutor interface
        //since it is an interface we cannot create an object
        //we just have to cast webdriver
        JavascriptExecutor js= (JavascriptExecutor)driver;
        //and then to execute script itself we call executeScript() method
        //executeScript() returns an object
        String title= (String)js.executeScript("return document.title");
        //or u can execute some script without any return
        js.executeScript("alert('Hello Spartans!!!')");
        SeleniumUtils.waitPlease(3);
        //Alert interface handles alerts
        //what is alert?
        //It looks like pop up window
        Alert alert= driver.switchTo().alert();
        alert.accept();
        //we can use accept() method to select Ok in the pop up
        SeleniumUtils.waitPlease(2);
        System.out.println(title);
    }
    @Test
    public void scrollTest1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        for(int i=0; i<11; i++){
            js.executeScript("window.scrollBy(0,250)");
        }
    }

    @Test
    public void scrollTest2(){
        driver.get("http://practice.cybertekschool.com");
        WebElement footerLink = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        SeleniumUtils.waitPlease(2);
        //scroll until footerLink is not visible
        //ones you see footerLink, script will stop scrolling
        js.executeScript("arguments[0].scrollIntoView(true)", footerLink);
        SeleniumUtils.waitPlease(2);
        //to click with jsexecutor
        js.executeScript("arguments[0].click()", footerLink);
        SeleniumUtils.waitPlease(2);

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
