package pages.vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.Locator;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class CalendarEventsPage {
    //    Verify repeat options
//    Log in as Valid user
//    Go to Activities -> Calendar Events
//    Click on create new calendar event
//    Click on Repeat checkbox
//    Verify repeat options:
//    Daily
//    Weekly
//    Monthly
//    Yearly

    //private--> to use  objects only in that class
   private WebDriver driver= Driver.getDriver();

  public String createCalendarEventBtnLocator= "a[title^='Create Calendar']";
  public String repeatCheckBoxLocator="input[id^='recurrence-repeat-view']";
  public String repeatsDropdownLocator="select[id^='recurrence-repeats-view']";
  public String repeatEveryRadioBtn1="(//input[@type='radio'])[1]";
  public String day_s_BtnLocator="input[name^='temp-validation-name']";



// let's write a method that would return collection of repeat options
   public List<String > getRepeatOptions(){
      //we create select object to work with dropdown
       Select select= new Select(driver.findElement(By.cssSelector(repeatsDropdownLocator)));
       //.getOptions(); return all available options in the dropdown
       List<WebElement> options =select.getOptions();
       //this is a collection that will store text of every option
        List<String> optionsTextList= new ArrayList<>();
            for (WebElement option:options) {
                //go through every option and retrieve text
                //add that text into collection of text options
                optionsTextList.add(option.getText());
            }
           return optionsTextList;
        }


    }

