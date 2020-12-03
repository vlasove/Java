package task5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(fileName);
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }

        int countSpaces = 0;
        int countChars = 0;
        try {
            while (stream.available() > 0) {
                Character letter = (char) stream.read();
                if (letter == ' '){
                    countSpaces++;
                }
                countChars++;
            }
            stream.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        System.out.printf("%.2f\n", (float) countSpaces/countChars * 100);

    }
}