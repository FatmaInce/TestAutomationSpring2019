package ScreenShotLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;
import teamActivities.Brite_ERP_Utils;
import utilities.SeleniumUtils;

public class HeadlessBrowser {
    @Test
    public void verifyTitle(){
        WebDriver driver=new HtmlUnitDriver();
        String userNameLocator="//input[@id='login']";
        String passwordLocator = "//input[@id='password']";
        String LoginLocator="//button[@class='btn btn-primary']";
        driver.get("http://34.220.250.213/web/login");
        System.out.println(driver.getTitle());
        WebElement usernameField = driver.findElement(By.xpath(userNameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("eventscrmmanager60@info.com");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("eventscrmmanager");
        // wait for 2 seconds
        SeleniumUtils.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(LoginLocator)).submit();
        SeleniumUtils.waitPlease(2);
        System.out.println(driver.getTitle());

    }
}