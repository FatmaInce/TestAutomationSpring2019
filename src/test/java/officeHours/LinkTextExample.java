package officeHours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkTextExample {
    static WebDriver driver= BrowserFactory.getDriver("chrome");


    public static void main(String[] args) throws Exception{
     //test1();
     test2();
    }
    public static void test1()throws Exception{
        //provides the synchronization between selenium and browser
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("A/B Testing")).click();

        Thread.sleep(2000);
        driver.navigate().back();
        driver.findElement(By.linkText("Dropdown")).click();
        Thread.sleep(2000);

        driver.close();

    }

    public  static void  test2()throws Exception{
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i =1; i< links.size(); i++) {
            if(i!=4) {// OR
                //if it's 4th link, skip it
//                if (i == 4) {
//                    continue;
//              }

//                if(i==4||i==41|| i==49){ // was on slack
//                    continue;
//                }
                Thread.sleep(1000);
                links.get(i).click();
                Thread.sleep(1000);
                driver.navigate().back();
                Thread.sleep(1000);
                links = driver.findElements(By.tagName("a"));
                System.out.println(links.get(i).getText());
            }
        }
        driver.close();
    }

}
