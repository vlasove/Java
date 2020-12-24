package lections.lec25;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        String firstFileName = args[0];
        String secondFileName = args[1];

        FileReader reader = null;
        FileWriter writer = null;

        try{
            reader = new FileReader(firstFileName);
            writer = new FileWriter(secondFileName);
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        //TODO: считать строку целиком , потом сделать split() , после чего найти слова содержащ цифры
    }

    public final boolean containsDigit(String s) {
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
