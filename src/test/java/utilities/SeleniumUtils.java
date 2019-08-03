package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {
    /**
     * @param expectedResult
     * @param actualResult   verifies if two strings are equals.
     */

    public static void verifyEquals(String expectedResult, String actualResult) {

        if (expectedResult.equals(actualResult)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
            System.out.println("Expected result:" + expectedResult);
            System.out.println("Actual result: " + actualResult);
        }
    }
    public static void waitPlease(double d) {
        try {
            Thread.sleep((long) d * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    public static void openPage(String page, WebDriver driver) {
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));
        for (WebElement example : listOfExamples) {
            if (example.getText().contains(page)) {
                example.click();
                break;
            }
        }
    }
    public static void verifyIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("PASSED");
            System.out.println(element.getText() + ": is visible");
        } else {
            System.out.println("FAILED");
            System.out.println(element.getText() + ": is not visible!");
        }
    }
    /**
     * This method will recover in case of exception unsuccessful click, and will try to click on element again.
     *
     * @param driver
     * @param by
     * @param attempts
     */
    public static void clickWithWait(WebDriver driver, By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                driver.findElement(by).click();
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                System.out.println(e);
                //print attempt
                System.out.println("Attempt :: " + ++counter);
                //wait for 1 second, and try to click again
                waitPlease(1);
            }
        }
    }
}