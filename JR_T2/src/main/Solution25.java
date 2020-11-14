package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution25 {
//    public static Map<String, Integer> months = new HashMap<>();
    public static void main(String[] args) throws  Exception {
//        months.put("January", 1);
//        months.put("February", 2);
//        months.put("March", 3);
//        months.put("April", 4);
//        months.put("May", 5);
//        months.put("June", 6);
//        months.put("July", 7);
//        months.put("August", 8);
//        months.put("September", 9);
//        months.put("October", 10);
//        months.put("November", 11);
//        months.put("December", 12);
        List<String> months = new ArrayList<>(Arrays.asList("January","February",  "March", "April","May", "June", "July", "August","September", "October","November","December"   ));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        System.out.println(month + " is the " + (months.indexOf(month) + 1)+ " month");


    }
}
