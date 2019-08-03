package homeworkVasyl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class EbaySearchTest_Jul_1 {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon", Keys.ENTER);

        String results= driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(results);

        driver.findElement(By.linkText("All")).click();
        String allResults=driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(allResults);








       // driver.close();

    }
}
