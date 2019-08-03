package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests4 {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openCheckBoxesPage();
       // test1();
        test2();

    }

    public static void openCheckBoxesPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        //let's make sure that checkboxes header is visible,
        // not only in the code
        WebElement checkboxesLogo = driver.findElement(By.tagName("h3"));
        if(checkboxesLogo.isDisplayed()){
            System.out.println("Check boxes Logo is visible");
        }else{
            System.out.println("Check boxes Logo is not visible");
        }
    }
    //verify that check if 1st box is not selected and box 2 is selected
    public  static void test1(){

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'[2]"));

  //to verify if checkbox 1 is not selected
    if(!checkBox1.isSelected()){
        System.out.println("Passed");
    }else{
        System.out.println("Failed");
    }

        //to verify if checkbox 2 is selected
        if(checkBox2.isSelected()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
      driver.close();

    }

    public static void test2(){
        openCheckBoxesPage();
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'[2]"));
        SeleniumUtils.waitPlease(2);
        checkBox1.click(); // to select it
        SeleniumUtils.waitPlease(2);
        checkBox2.click();
        SeleniumUtils.waitPlease(2);

        if(checkBox1.isSelected()&& (!checkBox2.isSelected())){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.close();
    }
}
