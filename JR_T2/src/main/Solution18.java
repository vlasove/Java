package main;

import java.util.HashMap;
import java.util.Map;

/*
Однофамильцы и тёзки
*/

public class Solution18 {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String, String> peoples = new HashMap<>();
        for(int i =0; i < 10;i++){
            peoples.put("Name" + i%3, "Lastname" + i%3);
        }

        return peoples;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
