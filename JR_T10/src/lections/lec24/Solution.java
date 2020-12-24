package lections.lec24;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String fileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            fileName = reader.readLine();
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }

        try{
            while(fileReader.ready()){
                containsWords(fileReader.readLine());
            }
            fileReader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void containsWords(String line){
        int counter = 0;
        for(String word : line.split("\\s")){
            for(String checkWord : words){
                if(word.equals(checkWord)){
                    counter++;
                }
            }
        }
        if(counter == 2){
            System.out.println(line);
        }
    }
}
