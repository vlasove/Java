package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Функциональности маловато!
*/

public class Solution27 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        while (true){
            String id = reader.readLine();
            if(id.isEmpty()){
                break;
            }
            String name = reader.readLine();
            if (name.isEmpty()) {
                map.put("", Integer.parseInt(id));
                break;
            }
            map.put(name, Integer.parseInt(id));
            
        }

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println("Id=" + pair.getValue() + " Name=" + pair.getKey());

        }
    }
}

