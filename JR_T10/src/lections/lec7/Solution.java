package lections.lec7;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = new String();
        try{
            fileName = reader.readLine();;
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        FileReader fileReader = null;
        try{
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
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

        Pattern WORLD_PATTERN = Pattern.compile("\\bworld\\b");
        Matcher countWorld = WORLD_PATTERN.matcher(sb.toString());

        int count = 0;
        while(countWorld.find()){
            count++;
        }

        System.out.println(count);
    }
}
