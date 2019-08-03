package day12_waits_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class ThreadSleepAndImplicitWaitTests {
    //http://practice.cybertekschool.com/dynamic_loading/2

    String helloWorldMessageLocator="#finish";//h4[.='Hello World!']
    String startButtonLocator="#start>button";
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                   }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
       //        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//
//        }
        String expectedResult= "Hello World!";
        String actualResult= driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String expectedResult= "Hello World!";
        String actualResult= driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
