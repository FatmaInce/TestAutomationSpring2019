package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeXpath5 {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws  Exception {
      test1();
    }

    public static void test1()throws InterruptedException{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("James Bond");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("student@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        driver.close();

    }
}
