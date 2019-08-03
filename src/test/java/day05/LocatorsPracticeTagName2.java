package day05;

import utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.concurrent.TimeUnit;



public class LocatorsPracticeTagName2 {

    static WebDriver driver= BrowserFactory.getDriver("chrome");



    public static void main(String[] args)throws Exception {
        //here we will execute the test
        //create separate method for every test

        //TASK: FIND ALL BUTTONS, put them in the list
        // and click them one by one

        test1();
    }
        public static void test1()throws Exception {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/multiple_buttons");
            //how to find all buttons?
        // we use findElementSSSSSS!!!!! to find multiple elements
        //then we have to use List to store elements
        List<WebElement> buttons= driver.findElements(By.tagName("button"));
            System.out.println("Size: " + buttons.size());//to get the number of elements in the list
        for(WebElement button: buttons){
            //we are getting buttons names. the previous version of the code
            // we could not be able to get 6. button’s name because
            // it is disappearing after clicking it.
            // that is why we are getting the text and then clicking
            // the buttons in the second version where we relocated the print statement
            System.out.println(button.getText());
            button.click();
           //System.out.println(button.getText());--> wont work,
            // because 6th button is disappearing after clicking the button
            Thread.sleep(1000);
        }
        driver.close();
        }

    }

