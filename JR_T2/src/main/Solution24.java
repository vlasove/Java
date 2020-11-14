package main;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
Работа с датой
*/

public class Solution24 {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        GregorianCalendar cal = new GregorianCalendar();
        int day = 0;
        try {
            Date curDate = formatter.parse(date);
            //System.out.println(curDate);
            cal.setTime(curDate);
            day = cal.get(GregorianCalendar.DAY_OF_YEAR);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return day % 2 !=0;
    }
}

