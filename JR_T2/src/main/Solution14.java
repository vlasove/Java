package main;

import java.util.HashMap;
import java.util.Map;


public class Solution14 {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        for(int i=0; i < 10; i++){
            if(i % 2 == 0){
                map.put("Name" + i, "Lastname" + 10);
            } else {
                map.put("Name" + i, "Lastname" + i);
            }

        }
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String, String> copyMap = new HashMap<>();
        copyMap.putAll(map);
        Map<String, Integer> counterMap = new HashMap<>();
        for(Map.Entry<String, String> pair : copyMap.entrySet()){
            if(counterMap.containsKey(pair.getValue())){
                counterMap.put(pair.getValue(), counterMap.get(pair.getValue()) + 1);
            } else {
                counterMap.put(pair.getValue(), 1);
            }
//
        }
        //printMapInt(counterMap);
        for(Map.Entry<String, Integer> pair : counterMap.entrySet()){
            if(pair.getValue() > 1){
                removeItemFromMapByValue(map, pair.getKey());
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void printMap(Map<String, String> map){
        for(Map.Entry<String, String> pair : map.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
    public static void printMapInt(Map<String, Integer> map){
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Initial map!");
        Map<String, String> m = createMap();
        printMap(m);
        System.out.println("After remover");
        removeTheFirstNameDuplicates(m);
        printMap(m);

    }
}
