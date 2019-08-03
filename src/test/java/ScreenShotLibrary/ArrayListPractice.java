package ScreenShotLibrary;

import org.testng.annotations.Test;

import java.util.*;

public class ArrayListPractice {
    @Test
    public void test1() {
        List<String> expectedColumnNames = Arrays.asList("Last name", "First name", "Email", "Due", "Web Site", "Action");
        //added column names in sorted list
        List<String> sorted = new ArrayList<>();
        sorted.addAll(expectedColumnNames);
        System.out.println();
        //use Collections class to sort all elements
        Collections.sort(sorted);
        sorted.addAll(expectedColumnNames);



        HashMap h1 =new LinkedHashMap();
        System.out.println(sorted);
        //get column data
        int colNumber=0;
        for (int i = 0; i <expectedColumnNames.size() ; i++) {



        }
    }
}