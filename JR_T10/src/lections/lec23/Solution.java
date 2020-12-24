package lections.lec23;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = args[0];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        try{
            while(reader.ready()){
                parsePerson(reader.readLine());
            }
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


    }

    public static void parsePerson(String line){
        String[] words = line.split("\\s");
        String year = words[words.length - 1];
        String month = words[words.length -2];
        String day = words[words.length - 3];

        String dateString = day + " " + month + " " + year;
        DateFormat df = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        Date date = null;
        try{
            date = df.parse(dateString);
        } catch (ParseException pe){
            pe.printStackTrace();
        }

        int cutTo = line.indexOf(day) - 1;
        String name = line.substring(0, cutTo);

        Person p = new Person(name, date);
        PEOPLE.add(p);

    }
}
