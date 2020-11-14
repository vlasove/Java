package main;

import java.util.HashMap;
import java.util.Map;

public class Solution12 {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        for(int i =0; i<10; i++){
            map.put("First" + i, "Second" + i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for(Map.Entry<String, String> pair : map.entrySet()){
            if(pair.getKey().equals(name)){
                count++;
            }
        }
        return count;

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for(Map.Entry<String , String> pair : map.entrySet()){
            if(pair.getValue().equals(lastName)) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {

    }
}