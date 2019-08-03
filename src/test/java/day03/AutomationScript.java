package day03;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //WebDriver replaces System.setProperty()
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://amazon.com");
        Thread.sleep(2000);

        WebElement inputBox1 = driver.findElement(By.id("twotabsearchtextbox"));
        inputBox1.sendKeys("laptop");

        WebElement submitButton1 = driver.findElement(By.name("field-keywords"));
        Thread.sleep(2000);
        submitButton1.submit();



        driver.navigate().back();
        WebElement inputBox2 = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement submitButton2 = driver.findElement(By.name("field-keywords"));
        inputBox2.sendKeys("Java Book");

        submitButton2.submit();
        Thread.sleep(2000);

        driver.navigate().back();

        Faker faker = new Faker();
        WebElement inputBox3 = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement submitButton3 = driver.findElement(By.name("field-keywords"));
        String name= faker.funnyName().name();

        inputBox3.sendKeys(name);
        submitButton3.submit();
        Thread.sleep(2000);

        //USE CLEAR() METHOD  //INPUT.CLEAR()
        // CONTINUE USING SENDKEYS() METHOD
        // use getAttribute

        driver.close();

    }

    }

