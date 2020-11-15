package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Soultion12 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String initDateString = reader.readLine();
        SimpleDateFormat formatterFirst = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date initDate = formatterFirst.parse(initDateString);
        SimpleDateFormat formatterSecond = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(formatterSecond.format(initDate).toUpperCase());
    }
}
