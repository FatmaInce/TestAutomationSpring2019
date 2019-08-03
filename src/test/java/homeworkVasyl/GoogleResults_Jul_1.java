package homeworkVasyl;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

import java.util.Arrays;
import java.util.List;

public class GoogleResults_Jul_1 {
    static WebDriver  driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        driver.get("https://www.google.com/");
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
    }
}
