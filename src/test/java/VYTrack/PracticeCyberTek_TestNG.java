package VYTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PracticeCyberTek_TestNG {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
       // driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
    }
    @Test
    public void test(){
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("super");
        driver.findElement(By.id("wooden_spoon")).click();


       String expectedMessage="Your password is invalid!";
       String actualMessage= driver.findElement(By.xpath("html/body/div/div/div/div")).getText();

       Assert.assertEquals(expectedMessage,actualMessage);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
