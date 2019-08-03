package day17_webtables_2;

import ScreenShotLibrary.CaptureScreenShot;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class WebTableTests extends TestBase {
    //http://practice.cybertekschool.com/tables

    /**
     * Write a method that will return count of rows
     */

    public int getCountOfRows() {
//        ==^_^==> Interesting fact
//        --> findElements() method and cssSelector won't return exception
//                --> Returns an empty list if no such element is found
        return driver.findElements(By.cssSelector("#table1 tr")).size();

    }

    /**
     * Overloaded version
     * Write a method that will return count of rows
     * In this case, object of by allows us to specify table locator of any type
     */


    public int getCountOfRows(By by) {
        return driver.findElements(by).size();
    }

    @Test
    public void getCountOfRowsTest1() {
        Assert.assertEquals(getCountOfRows(), 5, "Number of rows doesn't match");
    }

    @Test
    public void getCountOfRowsTest2() {
        Assert.assertEquals(getCountOfRows(By.xpath("//table[1]//tr")), 5, "Number of rows doesn't match");
    }

    /**
     * Write a method that will return count of columns
     */
    public int getCountOfColumns() {
        return driver.findElements(By.cssSelector("table1 th")).size();
    }

    /**
     * Overloaded version
     * Write a method that will return count of columns
     */
    public int getCountOfColumns(By by) {
        return driver.findElements(by).size();
    }

    @Test
    public void countOfColumnsTest1() {
        Assert.assertEquals(getCountOfColumns(), 6, "Number of columns doesn't match");
        //???????????????
        //???????????????
        //why does not work?
    }

    @Test
    public void countOfColumnsTest2() {
        Assert.assertEquals(getCountOfColumns(), 6, "Number of columns doesn't match");
    }
    /**
     * write a method that will return table size
     */
    public  int[]  gettableSize(){
        int[] size= {getCountOfRows(),getCountOfColumns()};
        return size;
    }
    /**
     * overloaded version
     * write amethod that will return table size
     * first value- number of rows
     * second value- number of columns
     */
    public  int[]  gettableSize(By rowLocator,By columnLocator){
        int[] size= {getCountOfRows(rowLocator),getCountOfColumns(columnLocator)};
        return size;
    }
    @Test
    public void tableSizeTest1(){
        int[] expectedSize= {5,6};
        int[] actualSize= gettableSize();
        Assert.assertEquals(actualSize,expectedSize,"Table size doesn't match");
        //????????????????
        //????????????????

    }
}