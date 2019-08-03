package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IDPractice {
    //to use driver object in every method make a static WebDriver driver object
    //BrowserFactory.getdriver("chrome");
    //add main method
    //add static with no return type (void)test method
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        try {
            test1();
        }catch (Exception e){

        }
        test2();


    }

    public static void test1() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.id("woodenspoon")).click();
        Thread.sleep(2000);
        driver.close();
    }

        public static void test2 ()throws Exception{
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/login");
            driver.findElement(By.name("username")).sendKeys("tomsmith");
            driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
            driver.findElement(By.id("wooden_spoon")).click();
            Thread.sleep(2000);String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
            String actualMessage= driver.findElement(By.className("subheader")).getText();

            SeleniumUtils.verifyEquals(expectedMessage,actualMessage);
            driver.findElement(By.linkText("Logout")).click();
            Thread.sleep(2000);
            driver.close();




    }

    public static class LocatorsPracticeClassName4 {

        static WebDriver driver= BrowserFactory.getDriver("chrome");
        // go to : http://practice.cybertekschool.com
        //TASK:  Get list of examples based on the classname list-
        //use for loop to get every element and print the text of this element
        // how many elements you will get, it must be 47

        public static void main(String[] args) {

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com");
            List<WebElement> examples=driver.findElements(By.className("list-group-item"));
            for(WebElement element: examples){
                System.out.println(element.getText());

            }
            driver.close();
        }
    }
}

