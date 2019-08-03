package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeID1 {
    static    WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {

//        try {
//            test1();
//        }catch (Exception e){
//
//        }

        test2();

    }
//negative test, we will use wrong id to locate element
    public static void test1()throws Exception {
        //WebDriver driver= BrowserFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            //selenium will wait 10 seconds for element
        //if, within 10 seconds element will not show up
        //u will get "NoSuchElementException"
            driver.get("http://practice.cybertekschool.com/login");
            driver.findElement(By.id("woodenspoon")).click();//wooden_spoon--> will work
            Thread.sleep(3000);//suspends java execution on certain time
            driver.quit();

    }
    public static void test2() throws InterruptedException {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //must use "implicitlyWait", otherwise u will be in trouble
        //this methods mean it will wait UP TO SPECIFIED TIME
        //But Thread.sleep strictly waits if how many seconds you passed
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        String expectedMessage="Welcome to static Secure Area. When you are done click logout below.";
        String actualMessage=driver.findElement(By.className("subheader")).getText();
        SeleniumUtils.verifyEquals(expectedMessage,actualMessage);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(3000);
        driver.quit();

    }
}
