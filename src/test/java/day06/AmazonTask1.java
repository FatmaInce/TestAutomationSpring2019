package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class AmazonTask1 {

//    TEST 1
//    go to amazon
//    enter any search term
//    click on search button
//    verify title contains search term

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args)throws Exception {

        test1();
    }

    public static void test1()throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("book");
        driver.findElement(By.className("nav-input")).click();
        String title= driver.getTitle();

        if(title.contains("book")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();

    }

}
