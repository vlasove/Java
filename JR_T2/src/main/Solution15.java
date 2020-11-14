package main;

import java.util.HashMap;
import java.util.Map;

/*
Только для богачей
*/

public class Solution15 {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            map.put("Name" + i, i * 100);
        }
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>(map);
        for(Map.Entry<String, Integer> pair : copy.entrySet()){
            if(pair.getValue() < 500){
                map.remove(pair.getKey());
            }
        }
    }



    public static void main(String[] args) {

    }
}
