package lections.lec5;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = this.fileScanner.nextLine();
            String[] parseLine = line.split("\\s+");
            String name = parseLine[1], lastname = parseLine[0], midname = parseLine[2];
            String day = parseLine[3], month = parseLine[4], year = parseLine[5];
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date date = null;
            try{
                date = formatter.parse(day + "-" + month + "-" + year);
            } catch (ParseException pe){
                pe.printStackTrace();
            }
            Person pers = new Person(name, midname, lastname, date);
            return pers;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}

