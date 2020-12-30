package tasks.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        String firstFileName = args[0];
        String secondFileName = args[1];
        String content = new String();
        List<String> inputContent = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(firstFileName))) {
            while ((content = in.readLine()) != null) {
                inputContent.add(content);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        List<String> stringToWrite = new ArrayList<>();
        for (String line : inputContent) {
            String[] words = line.split(" ");

            for (String word : words) {
                if (word.length() > 6) {
                    stringToWrite.add(word);
                }
            }
        }

        try (BufferedWriter out = new BufferedWriter(new FileWriter(secondFileName))) {
            out.write(String.join(",", stringToWrite));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}