package day15_review;

import com.google.common.base.Verify;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.vytrack.CalendarEventsPage;
import utilities.ConfigurationReader;
import utilities.SeleniumUtils;
import utilities.TestBase;
import utilities.VYTrackUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CalendarEventsTests extends TestBase {
    // @BeforeMethod is coming fromTestBase

    CalendarEventsPage calendarPage= new CalendarEventsPage();
    @Test
    public void verifyRepeatOptions(){
        //we are reading username from .properties file
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
        //driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();

        List<String> expectedOptions= Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<String> actualOptions=calendarPage.getRepeatOptions();
        //correct way to check if 2 collections are equals
        Assert.assertTrue(actualOptions.contains(expectedOptions));

    }


}
//After method is coming from TestBase