package lections.lec18;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String firstFileName = new String();
        String secondFileName = new String();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = consoleReader.readLine();
            secondFileName = consoleReader.readLine();
            consoleReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        List<String> firstFileStrings = readFile(firstFileName);
        List<String> secondFileStrings = readFile(secondFileName);
        checkDifference(firstFileStrings, secondFileStrings);
        printLines(lines);
    }

    public static void printLines(List<LineItem> lst) {
        for (LineItem li : lst) {
            System.out.print(li.type + " ");
            System.out.println(li.line);
        }
    }

    public static void checkDifference(List<String> first, List<String> second) {
        int f1ID = 0;
        int f2ID = 0;
        while (f1ID < first.size() && f2ID < second.size()) {
            //printLines(lines);
            // System.out.println("F1ID:" + f1ID + ", F2ID:" + f2ID);


            if (f1ID + 1 < first.size() && first.get(f1ID + 1).equals(second.get(f2ID))) {
                lines.add(new LineItem(Type.REMOVED, first.get(f1ID)));
                f1ID++;
                continue;

            } else if (f2ID + 1 < second.size() && first.get(f1ID).equals(second.get(f2ID + 1))) {
                lines.add(new LineItem(Type.ADDED, second.get(f2ID)));
                f2ID++;
                continue;
            } else if (first.get(f1ID).equals(second.get(f2ID))) {
                lines.add(new LineItem(Type.SAME, second.get(f2ID)));
                f1ID++;
                f2ID++;
                continue;
            } else {
                break;
            }

        }
        if (f2ID == second.size() && f1ID == first.size() - 1) {
            lines.add(new LineItem(Type.REMOVED, first.get(f1ID)));
            return;
        }
        if (f1ID == first.size() && f2ID == second.size() - 1) {
            lines.add(new LineItem(Type.ADDED, second.get(f2ID)));
            return;
        }

    }

    public static List<String> readFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        List<String> strings = new ArrayList<>();
        try {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return strings;
    }

    public static void printList(List<String> lst) {
        for (String row : lst) {
            System.out.println(row);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
