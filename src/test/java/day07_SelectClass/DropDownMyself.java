package day07_SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserFactory;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownMyself {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openDropDownPage();
        //test1();
        //test2();
        //test3();
       // test4();
        test5();
        SeleniumUtils.waitPlease(2);
        driver.close();

    }

    public static void openDropDownPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement element = driver.findElement(By.xpath("//h3[.='Dropdown List']"));
        if (element.isDisplayed()) {
            System.out.println("Passed");
            System.out.println("Element = " + element.getText());
        } else {
            System.out.println("Failed");
        }
    }

    public static void test1() {
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        Select sel = new Select(dropdown1);
        String selected = sel.getFirstSelectedOption().getText();
        System.out.println(selected);
        List<WebElement> options = sel.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }

    public static void test2() {
        WebElement state = driver.findElement(By.id("state"));
        Select selectedState = new Select(state);
        List<WebElement> states = selectedState.getOptions();
        for (WebElement stt : states) {
            System.out.println(stt.getText());
        }
        selectedState.selectByVisibleText("Virginia");
        SeleniumUtils.waitPlease(2);
        selectedState.selectByValue("TX");
        SeleniumUtils.waitPlease(2);
        selectedState.selectByIndex(13);
    }

    public static void test3() {
        WebElement state = driver.findElement(By.id("state"));
        Select selectedState = new Select(state);
        List<WebElement> states = selectedState.getOptions();
        for (WebElement option : states) {
            SeleniumUtils.waitPlease(1);
            selectedState.selectByVisibleText(option.getText());

           // System.out.println(stt.getText());
        }
    }

    public static void test4(){
        WebElement dropdownState= driver.findElement(By.id("state"));
        Select dropDownSelect= new Select(dropdownState);
        dropDownSelect.selectByValue("PA");
        String expected = "Pennsylvania";
        String actual = dropDownSelect.getFirstSelectedOption().getText();
        //System.out.println(actual);
        SeleniumUtils.verifyEquals(expected,actual);

    }

    public static void test5(){
        WebElement multiple = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select multipleSelect= new Select(multiple);
        multipleSelect.selectByVisibleText("Java");
        SeleniumUtils.waitPlease(1);
        multipleSelect.selectByVisibleText("JavaScript");
        SeleniumUtils.waitPlease(1);
        multipleSelect.selectByValue("c#");
        SeleniumUtils.waitPlease(1);
        multipleSelect.selectByValue("python");
        SeleniumUtils.waitPlease(1);
        multipleSelect.selectByIndex(4);
        SeleniumUtils.waitPlease(1);
        multipleSelect.selectByIndex(5);


    }

}
