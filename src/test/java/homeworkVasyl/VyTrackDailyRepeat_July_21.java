package homeworkVasyl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.vytrack.CalendarEventsPage;
import utilities.*;

public class VyTrackDailyRepeat_July_21 extends TestBase {
    // @BeforeMethod is coming fromTestBase

    CalendarEventsPage calendarPage= new CalendarEventsPage();

    //    Daily repeat option, Repeat every
//    Log in as Valid user
//    Go to Activities -> Calendar Events
//    Click on create new calendar event
//    Click on Repeat checkbox
//    Verify that Daily is selected by default
//    Verify day(s) checkbox is selected and default value is 1+
//    Verify summary says Daily every 1 day
//    Check the weekday checkbox
//    Verify that days input now disabled
//    Verify summary says Daily every weekday

    @Test
    public void dailyTest(){
        String username= ConfigurationReader.getProperty("storemanagerusername");
        //we are reading password from .properties file
        String password= ConfigurationReader.getProperty("storemanagerpassword");
        VYTrackUtils.login(driver, username, password); //login
        //go to Calendar Events

        VYTrackUtils.navigateToModule(driver,"Activities","Calendar Events");
        //since vytrack displays overlay screen during loading of the page
        //we have to wait until that overlay screen disappear
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);

        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        SeleniumUtils.clickWithWait(driver,By.cssSelector(calendarPage.repeatCheckBoxLocator),5);

        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        //Create WebElement object for Repeats dropdown for Select class
        WebElement defaultDaily= driver.findElement(By.cssSelector(calendarPage.repeatsDropdownLocator));
        //create select object out of Select class
        Select select =new Select(defaultDaily);


        //Verify that Daily is selected by default
        String expected="Daily";
        String actual= select.getFirstSelectedOption().getText();
        // System.out.println(actual);

        //Create a SoftAssert object, because many assertions will be done under one test.
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertEquals(actual,expected);

        //Verify day(s) checkbox is selected and default value is 1
        WebElement radioBtn1=driver.findElement(By.xpath(calendarPage.repeatEveryRadioBtn1));
        softAssertion.assertTrue(radioBtn1.isSelected());

        //Verify summary says Daily every 1 day





    }
}
