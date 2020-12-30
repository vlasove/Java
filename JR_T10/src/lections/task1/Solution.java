package lections.task1;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(12, "двенадцать");
        map.put(11, "одиннадцать");
        map.put(10, "десять");
        map.put(9, "девять");
        map.put(8, "восемь");
        map.put(7, "семь");
        map.put(6, "шесть");
        map.put(5, "пять");
        map.put(4, "четыре");
        map.put(3, "три");
        map.put(2, "два");
        map.put(1, "один");
        map.put(0, "ноль");
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = new String();
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String content = new String();
        List<String> stringInFile = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while ((content = in.readLine()) != null) {
                stringInFile.add(content);
            }
            in.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }


        for (String line : stringInFile) {
            String[] splitedLine = line.split(" ");
            for (int i = 0; i < splitedLine.length; i++) {
                for (Map.Entry<Integer, String> pair : map.entrySet()) {
                    try {
                        int number = Integer.parseInt(splitedLine[i]);
                        if (pair.getKey().equals(number)) {
                            splitedLine[i] = pair.getValue();
                        }
                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            for (String word : splitedLine) {
                sb.append(word).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
