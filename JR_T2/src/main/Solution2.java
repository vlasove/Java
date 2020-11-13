package main;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("арбуз", "ягода");
        m.put("банан", "трава");
        m.put("вишня", "ягода");
        m.put("груша" , "фрукт");
        m.put("дыня", "овощь");
        m.put("ежевика", "куст");
        m.put("жень-шень", "корень");
        m.put("земляника", "ягода");
        m.put("ирис" , "цветок");
        m.put("картофель", "клубень");

        for(Map.Entry<String, String> pair : m.entrySet()){
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

}
