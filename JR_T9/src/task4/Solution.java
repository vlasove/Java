package task4;

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

        int count = 0;
        try {
            while (stream.available() > 0) {
                Character letter = (char) stream.read();
                if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
                    count++;
                }
            }
            stream.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        System.out.println(count);

    }
}
