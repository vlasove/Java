package lections.lec10;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String firstFileName = new String();
        String secondFileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;


        try {
            fileReader = new BufferedReader(new FileReader(firstFileName));
            fileWriter = new BufferedWriter(new FileWriter(secondFileName));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        try {
            while (fileReader.ready()) {
                sb.append((char) fileReader.read());
            }
            fileReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Pattern DOTS_PATTERN = Pattern.compile("\\p{Punct}");
        Matcher matcher = DOTS_PATTERN.matcher(sb.toString());
        String ans = matcher.replaceAll("");

        try{
            fileWriter.write(ans);
            fileWriter.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
