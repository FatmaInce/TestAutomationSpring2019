package day11_vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SeleniumUtils;
import utilities.VYTrackUtils;

import java.util.concurrent.TimeUnit;

public class CreateButtonTests {
    WebDriver driver;
    String createButtonLocator = "a[title='Log call']"; // locator for log call button
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";

    @BeforeMethod
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");


    }
    @AfterMethod
    public void teardown() {
     driver.quit();
    }

    @Test
    public void storeManagerTest(){
        //login
        VYTrackUtils.login(driver, "storemanager85", "UserUser123");
        //navigate to the Calls
        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");
        //assert true that button "log call" is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(1);
        //navigate to the Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        //Verify that Create Calendar Event is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());
    }

    @Test
    public void salesManagerTest(){
        //login
        VYTrackUtils.login(driver, "salesmanager253", "UserUser123");
        SeleniumUtils.waitPlease(2);
        //navigate to the Calls
        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");
        SeleniumUtils.waitPlease(2);
        //assert true that button "log call" is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(1);
        //navigate to the Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(2);
        //Verify that Create Calendar Event is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());
    }
    }

