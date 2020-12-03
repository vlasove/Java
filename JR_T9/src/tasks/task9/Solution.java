package tasks.task9;

import java.io.*;
import java.util.*;

/*
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        BufferedReader reader = null;
        String line = new String();
        String totalText = new String();
        //Считываем строку с текстом
        try{
            //TODO: Сделать считывание по символам
            reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null){
                totalText += line;
            }
            reader.close();
        } catch (FileNotFoundException ffe){
            ffe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        //System.out.println(totalText);

        Map<Character, Integer> counter = createCounter(totalText);

        List<Pair> listPairsCounter = createSortedList(counter);
//        for(Pair pair : listPairsCounter){
//            System.out.println(pair.key + " " + pair.value);
//        }
        Comparator<Pair> compareByASCII = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int result = 0;
                int val1 = (int) o1.key;
                int val2 = (int) o2.key;
                if(val1 > val2){
                    result = 1;
                } else if(val1 < val2){
                    result = -1;
                }
                return result;
            }
        };
        Collections.sort(listPairsCounter, compareByASCII);
        for(Pair pair : listPairsCounter){
            System.out.println(pair.key  + " " + pair.value);
        }
    }

    public static Map<Character, Integer> createCounter(String totalText){
        Map<Character, Integer> counter = new HashMap<>();
        for(int i=0; i < totalText.length(); i++){
            if(counter.containsKey(totalText.charAt(i))){
                counter.put(totalText.charAt(i), counter.get(totalText.charAt(i)) + 1);
            } else {
                counter.put(totalText.charAt(i), 1);
            }
        }
        return counter;
    }

    public static List<Pair> createSortedList(Map<Character, Integer> counter){
        List<Pair> lst = new ArrayList<>();
        for(Map.Entry<Character, Integer> pair : counter.entrySet()){
            Pair currentPair = new Pair(pair.getKey(), pair.getValue());
            lst.add(currentPair);
        }

        return lst;
    }

    public static class Pair {
        public Character key;
        public Integer value;

        public Pair(Character key, Integer value){
            this.key = key;
            this.value = value;
        }

        public Character getKey(){
            return this.key;
        }

        public Integer getValue(){
            return this.value;
        }
    }
}
