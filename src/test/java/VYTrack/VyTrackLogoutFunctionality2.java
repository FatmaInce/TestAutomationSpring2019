package VYTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class VyTrackLogoutFunctionality2 {
    //create a static object so that u can use the object easily
    //in the other static methods.
    //http://practice.cybertekschool.com/login
static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        //here we will execute the test
        //create separate method for each test
        test1();
    }

    public static void test1() throws InterruptedException{
        driver.manage().window().maximize();

        //must use "implicitlyWait", otherwise u will be in trouble
        //this methods mean it will wait UP TO SPECIFIED TIME
        //But Thread.sleep strictly waits if how many seconds you passed
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

        //to send the username to username-box
        //check inspect & if id is not dynamic,use id
        driver.findElement(By.id("prependedInput")).sendKeys("user40");
        //Thread.sleep() method means wait.... seconds
        // from going one line of code to the next line!!! It is not about the website.
        Thread.sleep(1000);

        ///to send the password to password-box
        //check inspect & if id is not dynamic,use id
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Thread.sleep(1000);

        //click login button
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(1000);

        //can also call this method from SeleniumUtils class
        //SeleniumUtils.verifyEquals(expectedMessage,actualMessage);

        //click on the button next to user name
        driver.findElement(By.className("fa-caret-down")).click();
        Thread.sleep(1000);

        //see the dropdown menu
        driver.findElement(By.className("dropdown-menu"));
        Thread.sleep(1000);


        
        driver.findElement(By.xpath("//a[.='Logout']")).click();
        Thread.sleep(1000);

        String expectedLoginPageTitle="Login";
        String actualLoginPageTitle= driver.findElement(By.className("title")).getText();


        if(expectedLoginPageTitle.equals(actualLoginPageTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected: "+ expectedLoginPageTitle);
            System.out.println("Actual: " + actualLoginPageTitle);

        }

              driver.close();




    }

}
