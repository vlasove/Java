package lections.lec21;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        Map<String, Double> map = new HashMap<>();
        try{
            while(reader.ready()){
                String[] items = reader.readLine().split("\\s");
                String name = items[0];
                Double value = Double.parseDouble(items[1]);

                if(map.containsKey(name)){
                    map.put(name, map.get(name) + value);
                } else {
                    map.put(name, value);
                }
            }
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        List<Pair> list = createListOfPairs(map);
        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        for (Pair p : list){
            System.out.println(p.getName() + " " + p.getValue());
        }
    }

    public static List<Pair> createListOfPairs(Map<String, Double> m){
        List<Pair> list = new ArrayList<>();
        for(Map.Entry<String, Double> p : m.entrySet()){
            list.add(new Pair(p.getKey(), p.getValue()));
        }
        return list;
    }

    public static class Pair {
        private String name;
        private Double value;

        public Pair(String name, Double value){
            this.name = name;
            this.value = value;
        }

        public String getName(){
            return this.name;
        }

        public Double getValue(){
            return  this.value;
        }
    }

}

