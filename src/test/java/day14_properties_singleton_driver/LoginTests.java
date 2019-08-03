package day14_properties_singleton_driver;

import org.testng.annotations.Test;
import pages.vytrack.LoginPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class LoginTests extends TestBase {
    LoginPage loginPage= new LoginPage();

    @Test
    public void loginTest1(){
        //DEMO for reading credentials from properties file
        String username= ConfigurationReader.getProperty("username");
        String password= ConfigurationReader.getProperty("password");
        loginPage.login(username,password);


    }

}
