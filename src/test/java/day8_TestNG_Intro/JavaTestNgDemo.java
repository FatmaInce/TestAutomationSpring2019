package day8_TestNG_Intro;
import org.testng.Assert;
import org.testng.annotations.Test;
public class JavaTestNgDemo  {
    @Test
    public void Test1() {

        String a = "A";
        String b = "A";
        Assert.assertEquals(a, b);

    }
    @Test
    public void Test2() {

        String a = "A";
        String b = "B";
        Assert.assertEquals(a, b);

    }

    @Test
    public void test3(){
        String str1 = "ADAF";
        String str2 = "AAA";
        Assert.assertTrue(str1.contains(str2));
    }

    @Test// bu testi herzaman eklemek zorundayiz herseferinde code run edeceksek

    public void test4(){
        Assert.assertFalse(false);
    }
}






