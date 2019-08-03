package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class WayFairPractice {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args)throws Exception {
        test();

    }

    public static void test() throws Exception{
        driver.get("https://www.etsy.com/");
        driver.findElement(By.id("search-query")).
                sendKeys("spoon");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
