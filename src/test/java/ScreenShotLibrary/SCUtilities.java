package ScreenShotLibrary;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class SCUtilities {
    public static void captureScreenShot(WebDriver driver, String screenShotName){
        try{
            TakesScreenshot file=(TakesScreenshot)driver;
            File source=file.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File("./ScreenshotLibrary/"+ screenShotName + ".jpg"));
           // FileUtils.copyFile(source, new File("C:\Users\Fatma Ince\IdeaProjects\TestAutomationSpring2019\src\test\java"+screenShotName+".jpg"));
           //WHY ABOVE FILE PATH IS GIVING ERROR?
        }catch(Exception e){
            System.out.println("while taking the screenshot happened the exception"+e.getMessage());
        }
    }
}
