package homeworkVasyl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class VytrackTitleTest_Jul_1 {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        vyTrackLogin();
        //test1();
        test2();

    }

    public static void vyTrackLogin(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");

    }

    public static void getTitle(String expectedTitle,String actualTitle){

        if(expectedTitle.contains(actualTitle)){
            System.out.println("Passed Title Test");
        }else{
            System.out.println("Failed Title Test");
            System.out.println("Expected Title is: " + expectedTitle);
            System.out.println("Actual Title = " + actualTitle);
        }


    }

    public static void test1() {

        driver.findElement(By.id("prependedInput")).sendKeys("user40");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        SeleniumUtils.waitPlease(1);
        WebElement userName = driver.findElement(By.className("dropdown-toggle"));
        String actualUserName = userName.getText();
        // System.out.println(actualUserName);
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.xpath("//a[.='My Configuration']")).click();
        String title = driver.getTitle();
        //System.out.println(title);

        if (title.contains(actualUserName)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.close();

    }

   public static void test2(){
        //Login as a store manager
       driver.findElement(By.id("prependedInput")).sendKeys("storemanager77");
       SeleniumUtils.waitPlease(1);
       driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
       SeleniumUtils.waitPlease(1);
       // Verify Dashboard page is open
       String expectedTitle1="Dashboard";
       String actualTitle1=driver.getTitle();
       getTitle(expectedTitle1,actualTitle1);
       SeleniumUtils.waitPlease(2);
       //click on shortcuts icon, then click on "See full list"
       driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
       driver.findElement(By.className("dropdown-menu"));
       driver.findElement(By.xpath("//a[.='See full list']")).click();
       SeleniumUtils.waitPlease(2);
       driver.findElement(By.linkText("Opportunities")).click();
       SeleniumUtils.waitPlease(2);
       String expectedTitle2="Open Opportunities - Opportunities - Sales";
       String actualTitle2=driver.getTitle();
       getTitle(expectedTitle2,actualTitle2);
       //click on shortcuts icon, then click on "See full list"
       driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
       driver.findElement(By.className("dropdown-menu"));
       driver.findElement(By.xpath("//a[.='See full list']")).click();
       //Click on link Vehicle Service Logs
       driver.findElement(By.linkText("Vehicle Services Logs")).click();
       //Verify error message text is You do not have permission to perform this action.
       String expectedErrorMessage="You do not have permission to perform this action.";
       String actualErrorMessage= driver.findElement(By.className("message")).getText();
       //Verify Open opportunities page is still open
       if(expectedErrorMessage.equals(actualErrorMessage)){
           System.out.println("Passed");
       }else{
           System.out.println("Failed ");
           System.out.println("Expected Error Message = " + expectedErrorMessage);
           System.out.println("Actual Error Message = " + actualErrorMessage);

       }

       getTitle(expectedTitle2,actualTitle2);


   }
}

