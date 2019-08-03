package VYTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrackLogIn1 {

    public static void main(String[] args)throws Exception {
        //create webdriver manager to access google chrome
        WebDriverManager.chromedriver().setup();
        //create a Chromedriver object to utilize available methods
        WebDriver driver = new ChromeDriver();

        //to maximize the page
         driver.manage().window().maximize();

         //use driver object to go to VYTrack login page
        driver.get("http://qa2.vytrack.com/user/login");
        //stay on page for 3 seconds, use Thread.sleep method
        // you need to use either try-catch or throws Exception
        Thread.sleep(3000);
        //create three elements, one for userNameBox,
        // one for passwordBox, and one for submitButton

        //we will implement two locators. they are "id" and "name" locators
        WebElement userNameBox= driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement logInButton = driver.findElement(By.id("_submit"));

        //first insert the user name in the "UserName" field
        userNameBox.sendKeys("user41");
        Thread.sleep(1000);
        //second insert the password in the "password" field
        password.sendKeys("UserUser123");
        Thread.sleep(1000);
        //third click on "Login" button to access VYTrack modules
        logInButton.click();
        Thread.sleep(1000);

        //create a text if login is unsuccessful
        String failed= "Invalid user name or password.";

        //create if else condition to check whether the title of webpage is correct
        if(driver.getTitle().contains("Dashboard")){
            System.out.println("Passed\nExpected: " + driver.getTitle());
        //if the page title is not correct,use else
        }else{
            System.out.println(failed);
            // printout the actual result that failed the verification of title condition
            System.out.println("Actual:" + driver.getTitle());
        }



        //close the tab
        driver.close();







    }
}
