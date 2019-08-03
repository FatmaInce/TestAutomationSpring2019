package day10_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class MultipleButtonsTestsWithCSSSelector {
    String button1Locator="[onclick='button1()']";
    String button2Locator=".btn.btn-primary:nth-of-type(2)";
    //^---> means "starts-with
    String button3Locator="[id^='button_']";
    //we specified two attributes
    //$---> means "ends-with
    String button4Locator="[id$='_button'][onclick='button4()']";
    //*----> means "contains"
    String button5Locator="[onclick*='5']";
    //#---> means "id" in Css
    String button6Locator="#disappearing_button";
    //html>div>div:nth-of-type(2)>div>div:nth-type-of(1)>p
    String resultLocator="#result";

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();

    }
    @BeforeMethod
    public  void setup(){
        //first initialize driver, otherwise u will get exception
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }
   // @Ignore  //----> will ignore this test//not even running the test
    @Test(priority = 1,description = "Verifying button 1")
    //@Test(priority = 1,description = "Verifying button 1",enabled=false)
    //enabled=false-->like @Ignore
    public void button1Test(){

        driver.findElement(By.cssSelector(button1Locator)).click();
        String expectedMessage= "Clicked on button one!";
        String actualMessage=driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test(priority = 2, dependsOnMethods = {"button1Test"})
    // "dependsOnMethods" will indicate methods that affects on current tests.
    //if those method fails, it will ignore method with dependency
    //@Test(priority = 2)
    public void button2Test() {

        driver.findElement(By.cssSelector(button2Locator)).click();
        String expectedMessage = "Clicked on button two!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        SeleniumUtils.waitPlease(3);
        //put throw at the end,otherwise it will be unreachable code
      //  throw new SkipException("I don't want to run this test.");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
}
}
