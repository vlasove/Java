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
        try{
            firstFileName = consoleReader.readLine();
            secondFileName = consoleReader.readLine();
            consoleReader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        List<String> firstFileStrings = readFile(firstFileName);
        List<String> secondFileStrings = readFile(secondFileName);


        System.out.println("First file:");
        printList(firstFileStrings);

        System.out.println("Second file:");
        printList(secondFileStrings);
    }
    public static List<String> readFile(String fileName){
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(fileName));
        } catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        List<String> strings = new ArrayList<>();
        try{
            while(reader.ready()){
                strings.add(reader.readLine());
            }
            reader.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return strings;
    }
    public static void printList(List<String> lst){
        for(String row : lst){
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
