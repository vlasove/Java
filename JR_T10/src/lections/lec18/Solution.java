package lections.lec18;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    //Итоговый список
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        //Инициализация переменных под имена файлов
        String firstFileName = new String();
        String secondFileName = new String();

        //Считывание имен и работа с входным потоком
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = consoleReader.readLine();
            secondFileName = consoleReader.readLine();
            consoleReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        //Формируем списки из строк, находящихся в файлах
        List<String> firstFileStrings = readFile(firstFileName);
        List<String> secondFileStrings = readFile(secondFileName);


        //Проверяем разницу между списками и наполняем lines
        checkDifference(firstFileStrings, secondFileStrings);

        //Отладочный блок
        printLines(lines);
    }

    public static void checkDifference(List<String> first, List<String> second) {

        /**
         * Первый вариант - не самый удачный, хотя все тесты проходит

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
         */


        //Второй вариант
        while (!first.isEmpty() && !second.isEmpty()) {
            String firstLine = first.get(0);
            String secondLine = second.get(0);
            if (first.get(0).equals(second.get(0))) {
                lines.add(new LineItem(Type.SAME, secondLine));
                first.remove(0);
                second.remove(0);
            } else if (first.get(1).equals(second.get(0))) {
                lines.add(new LineItem(Type.REMOVED, firstLine));
                first.remove(0);
            } else {
                lines.add(new LineItem(Type.ADDED, secondLine));
                second.remove(0);
            }
        }

        if (first.size() > 0) {
            lines.add(new LineItem(Type.REMOVED, first.get(0)));
        } else if (second.size() > 0) {
            lines.add(new LineItem(Type.ADDED, second.get(0)));
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

    public static void printLines(List<LineItem> lst) {

        /**
         * Функция для распечатки итогового списка
         * Вывод идет в формате `Type String`
         */

        for (LineItem li : lst) {
            System.out.print(li.type + " ");
            System.out.println(li.line);
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
