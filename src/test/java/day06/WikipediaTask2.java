package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class WikipediaTask2 {

//    TEST 2
//    go to wikipedia.org
//    enter search term ‘selenium webdriver’
//    click on search button
//    click on search result ‘Selenium (software)’
//    verify url ends with ‘x’

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args)throws Exception {

        test1();
    }
    public static void test1()throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",
                Keys.ENTER);
        //******************IMPORTANT*****************
       //!!!!!!! if you use Keys.ENTER u dont have to find click button and click() on it.
       // driver.findElement(By.className("sprite svg-search-icon")).click();
        driver.findElement(By.linkText("Selenium (software)")).click();

        String url= driver.getCurrentUrl();

        if(url.endsWith("x")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        driver.close();
    }
}
