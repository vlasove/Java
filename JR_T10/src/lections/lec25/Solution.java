package lections.lec25;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String firstFileName = args[0];
        String secondFileName = args[1];

        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader(firstFileName);
            writer = new FileWriter(secondFileName);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String content = new String();
//        BufferedReader buffReader = new BufferedReader(reader);
        try {
            int intValueOfChar;
            while ((intValueOfChar = reader.read()) != -1) {
                content += (char) intValueOfChar;
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        //TODO: считать строку целиком , потом сделать split() , после чего найти слова содержащ цифры
        String[] words = content.split("\\s");
        List<String> answerStrings = new ArrayList<>();
        for (
                String word : words) {
            if (containsDigit(word)) {
                answerStrings.add(word);
            }
        }


        String ans = String.join(" ", answerStrings);
        try {
            writer.write(ans);
            writer.close();
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }
}
