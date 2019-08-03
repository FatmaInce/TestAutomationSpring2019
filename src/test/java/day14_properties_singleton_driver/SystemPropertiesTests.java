package day14_properties_singleton_driver;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class SystemPropertiesTests {
    @Test
    public void systemPropertiesTest1(){
        String os= System.getProperty("os.name");
        String username= System.getProperty("user.name");
        String javaVersion=System.getProperty("java.specification.version");
        String homeDirectory=System.getProperty("user.home");
        System.out.println(os);
        System.out.println(username);
        System.out.println(javaVersion);
        System.out.println(homeDirectory);
        Properties properties= System.getProperties();
        //this an entry setof all properties
        //since it's a key, value pair, we use Map to store information
        for(Map.Entry<Object,Object>property:properties.entrySet()){
            //get key of every item(os.name)   value of every property(Windows 10)
            System.out.println("Key: "+ property.getKey()+", Value: "+property.getKey());
        }


    }
}
