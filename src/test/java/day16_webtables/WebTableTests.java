package day16_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class WebTableTests extends TestBase {

    @Test
    public void printTableTest() {
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());

    }

    @Test
    public void printHeaderRow() {
        //chaining of findElement()
        WebElement header = driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
        System.out.println(header.getText());
    }

    @Test(description = "without header, find the number of rows in the first table")
    public void countRowsTest() {
        //means find table with id table1 then go to tbody and any tr
        //it represents number of rows in the first table
        String locator = "table[id='table1]>tbody tr";
        //(space) means child in cssSelector
        List<WebElement> rows = driver.findElements(By.cssSelector(locator));
        System.out.println("Size: " + rows.size());

    }

    @Test(description = "get number of rows in the second table, including header")
    public void countRowsTest2() {
        String locator = "#table2 tr";
        List<WebElement> rows = driver.findElements(By.cssSelector(locator));
        Assert.assertEquals(rows.size(), 5);
        //????????????
        //????????????
        //should be a number on console
    }

    //Task: Print all columns names from table1
    //every column name should be printed from new line
    @Test
    public void printTableHeaders() {
        //  //table[@id='table1']//th
        //  //table[1]/thead/tr/th[2]-->/ means direct child(u have to use direct child!!!!!)
        String locator = "#table1 th";
        List<WebElement> headers = driver.findElements(By.cssSelector(locator));
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }
    //print certain row
    @Test
    public void printSpecificRow(){

         // TRY THIS CSS:table :nth-child(1) tr :nth-child(3)
        int row=3;
        String locator="//table[1]//tbody//tr["+row+ "]";
        WebElement rowElement= driver.findElement(By.xpath(locator));
        System.out.println(rowElement.getText());

    }
    //let's write a method that will return column based on column name
    @Test
    public void  printColumnTest(){
        System.out.println(getColumn("Email"));
    }

    @Test
    public void verifyThatNameDisplays(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String actualName = driver.findElement(By.xpath(firstNameLocator)).getText();
        String actualLastName = driver.findElement(By.xpath(lastNameLocator)).getText();

        Assert.assertEquals(actualName, firstName);
        Assert.assertEquals(actualLastName, lastName);
    }

    @Test(dependsOnMethods = "verifyThatNameDisplays")
    public void verifyThatRecordHasBeenDeletedTest(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String target = "//table[1]//td[text()='"+lastName+"']";

        String deleteLocator = "//table[1]//td[text()='"+lastName+"']/following-sibling::td//a[text()='delete']";

        driver.findElement(By.xpath(deleteLocator)).click();

        Assert.assertTrue(driver.findElements(By.xpath(target)).isEmpty());
    }


    public List<String> getColumn(String columnName){


        List<String > values = new ArrayList<>();
        //all headings
        List<WebElement> headings= driver.findElements(By.xpath("//table[1]//th"));
        int columnNumber= 0;
        //we are looping through collection of headings
        for(int i=0; i<headings.size();i++){
            //we are looking for position of heading
            if(headings.get(i).getText().equals(columnName)){
                columnNumber=i+1;
                break;
            }
        }
      // based on position that we found in previous loop, we are allocating column
      List<WebElement> columnList=driver.findElements(By.xpath("//table[1]//tr//td["+columnNumber+"]"));

      for(WebElement columnValue: columnList){
          values.add(columnValue.getText());
      }
      return values;
    }

}
