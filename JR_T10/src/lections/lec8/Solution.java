package lections.lec8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String firstFileName = new String();
        String secondFileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;


        try{
            fileReader = new BufferedReader(new FileReader(firstFileName));
            fileWriter = new BufferedWriter(new FileWriter(secondFileName));
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        try{
            while(fileReader.ready()){
                sb.append((char) fileReader.read());
            }
            fileReader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


        Pattern NUMERIC_PATTERN = Pattern.compile("\\b[0-9]+\\b");
        Matcher countNumericMatcher = NUMERIC_PATTERN.matcher(sb.toString());
        List<String> numStrings = new ArrayList<>();
        while(countNumericMatcher.find()){
            numStrings.add(countNumericMatcher.group());
        }

        try{
            fileWriter.write(String.join(" ", numStrings));
            fileWriter.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
