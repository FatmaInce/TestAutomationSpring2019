package day14_properties_singleton_driver;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.SeleniumUtils;

public class SingletonDriverTests {
    @Test
    public void test1(){
        Driver.getDriver().get("http://google.com");
        SeleniumUtils.waitPlease(3);
        Driver.closeDriver();//to completely shut down driver
    }
}
