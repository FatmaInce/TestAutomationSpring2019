package VYTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCybertekLogIn {
    public static void main(String[] args)throws Exception {


        //create webdriver manager to access google chrome
        WebDriverManager.chromedriver().setup();
        //create a Chromedriver object to utilize available methods
        WebDriver driver = new ChromeDriver();

        //to maximize the page
        driver.manage().window().maximize();

        //use driver object to go to VYTrack login page
        driver.get( "http://practice.cybertekschool.com/login");

        //stay on page for 3 seconds, use Thread.sleep method
        // you need to use either try-catch or throws Exception
        Thread.sleep(3000);

        //create two elements, one for userNameBox,
        // one for passwordBox, and one for submitButton

        WebElement userNameBox=driver.findElement(By.name("username"));
        WebElement password= driver.findElement(By.name("password"));
        WebElement logInButton= driver.findElement(By.id("wooden_spoon"));

        //first insert the user name in the "UserName" field
        userNameBox.sendKeys("tomsmith");

        //second insert the password in the "password" field
        password.sendKeys("super");

        //third click on "Login" button to access VYTrack modules
        logInButton.click();


        // I want to get the title of the current page when login is unsuccessful
        System.out.println("title of the page: " + driver.getTitle());

        //Actual: User logged in, 
        //Expected:

        if(driver.getTitle().equals("Practice")){
            System.out.println("Test Passed");
        }


        driver.close();














    }

}
