package teamActivities;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Brite_ERP {
    // http://54.148.96.210/web?#menu_id=115&action=120&active_id=channel_inbox
    //email:EventsCRM_User8@info.com           password: opJu56KKL46

    //Create driver object
    WebDriver driver;
    //Create Locators
    String contactsLocator = "(//span[@class='oe_menu_text' and contains(text(),'Contacts')])[1]";
    String searchLocator = ".o_searchview_input";
    String printButtonLocator = "//button[@aria-expanded='false' and contains(text(),'Print')]";
    String duePaymentsLocator = "//a[@data-section='print' ]";
    String logNoteLocator = "//textarea[@placeholder='Write something...']";
    String numberOfContactsLocator="//span[@class='o_pager_limit']";
    String randomContactLocator=" //div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']";
    @BeforeClass
    public void setUp1() {
        // Setup for webDriverManager to access chrome driver
        WebDriverManager.chromedriver().setup();
        //Assign driver to chrome
        driver = new ChromeDriver();
        //maximize the page
        driver.manage().window().maximize();
        //The implicit wait will tell to the web driver to wait for certain amount of time
        // before it throws a "No Such Element Exception".
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get() method waits for page to load
        driver.get("http://54.148.96.210/web?#menu_id=115&action=120&active_id=channel_inbox");
    }
    @BeforeGroups(groups = {"a"})
    public void userLogin() {
        //login as user
        Brite_ERP_Utils.login(driver,"EventsCRM_User8@info.com","opJu56KKL46");
//        driver.findElement(By.id("login")).sendKeys("EventsCRM_User8@info.com");
//        //input password login
//        driver.findElement(By.id("password")).sendKeys("opJu56KKL46");
//        //then click the login button to enter web-page
//        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Click Contacts on top menu bar
       // driver.findElement(By.xpath(contactsLocator)).click();
        SeleniumUtils.waitPlease(2);
    }
    @Test(groups = {"a"},description = "CN-11 Testing from user perspective that user can print due payments")
    public void duePaymentButtonTest() {
        //Type the name you wanted to search for due payment in search box
        driver.findElement(By.cssSelector(searchLocator)).sendKeys("Fatma", Keys.ENTER);
        SeleniumUtils.waitPlease(2);
        //Creates list of WebElements for the number of contacts
        List<WebElement> allContacts= driver.findElements(By.xpath(randomContactLocator));
        //looping to click on a random contact
        for(int i=0; i<allContacts.size()-1;i++){
            WebElement randomContact=allContacts.get(i);
            randomContact.click();
        }
        //Click on the print button
        driver.findElement(By.xpath(printButtonLocator)).click();
        //Click on the due payments
        driver.findElement(By.xpath(duePaymentsLocator)).click();

        //use explicit wait
        //how to check if pdf is downloaded
    }
    @Test(groups = {"a"},description = "CN-12 Testing from user perspective that user add notes  to Log Note section.")
    public void logNoteTest() {
        //Testing from user perspective that user add notes  to Log Note section
        driver.findElement(By.cssSelector(searchLocator)).sendKeys("Fatma", Keys.ENTER);
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("//span[.='Fatma Ince']")).click();
        SeleniumUtils.waitPlease(2);
        WebElement footerLink = driver.findElement(By.cssSelector(".btn.btn-sm.btn-link.o_chatter_button_log_note"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        js.executeScript("arguments[0].scrollIntoView(true)", footerLink);
        footerLink.click();
        WebElement logNote = driver.findElement(By.xpath(logNoteLocator));
        Assert.assertTrue(logNote.isDisplayed());
    }
    @BeforeGroups(groups = {"b"})
    public void managerLogin() {
        //manager login
        Brite_ERP_Utils.login(driver,"Lunch_InvoicingManager3@info.com","LD686gfX24");

    }
    @Test(groups = {"b"},description ="Verify that user should be able to see the list view.")
    public void crmModuleTest() {
        //As a user, when I already created an opportunity in CRM module of Bribe ERP application,
        //I want to be able to delete it.
        //Step 1: Click on CRM Module
        //Step 2: Click on List button on top right side
        //Step 3: Click on one of the checkboxes.
        //Step 4: Click on the Action button
        //Step 5: Click on "Delete" from dropdown menu.

        //Click on CRM module by using Relative xpath
        driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'CRM')]")).click();
        //Click on the list button to see product in a list view by using relative xpath
        driver.findElement(By.xpath("//button[@aria-label='list']")).click();
        SeleniumUtils.waitPlease(3);
        //getText() gets total number of products showing in string format before deletion
        String listFirst=driver.findElement(By.xpath(numberOfContactsLocator)).getText();
        System.out.println("Before deletion:" +driver.findElement(By.xpath(numberOfContactsLocator)).getText());
        //Change the string format into integer
        int listNum1=Integer.parseInt(listFirst);
        //1. Verify that user should be able to see the list view.
        Assert.assertTrue(listNum1>0);
        //Select a checkbox for the product
        driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//input[1]")).click();
        SeleniumUtils.waitPlease(2);
        //Click on the action button to see delete button
        driver.findElement(By.xpath("//button[@data-toggle='dropdown' and contains(text(),'Action')] ")).click();
        SeleniumUtils.waitPlease(2);
        //Click on the delete element
        driver.findElement(By.xpath("//a[@data-index='3']")).click();
        SeleniumUtils.waitPlease(2);
        //Click on the ok element to verify deletion
        driver.findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
        SeleniumUtils.waitPlease(2);
        //getText() gets total number of products showing in string format
        String listSecond=driver.findElement(By.xpath(numberOfContactsLocator)).getText();
        System.out.println("After deletion: "+driver.findElement(By.xpath(numberOfContactsLocator)).getText());
        //Change the string format into integer
        int listNum2=Integer.parseInt(listSecond);
        //2.Verify that user should be able to delete the opportunity from action drop down list.
        Assert.assertTrue(listNum1>listNum2);

    }
    @AfterClass
    public void tearDown(){driver.quit();}
}



