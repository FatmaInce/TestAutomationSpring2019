package teamActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.SeleniumUtils;

public class Brite_ERP_Utils {
    private static String usernamelocator="login";
    private static String passwordlocator="password";
    private static String loaderMaskLocator="div[class='loader-mask shown']";



    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id(usernamelocator)).sendKeys(username);
        driver.findElement(By.id(passwordlocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtils.waitPlease(3);

    }
}
