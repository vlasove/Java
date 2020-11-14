package main;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution27 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            String family = reader.readLine();


            map.put(city, family);
        }

        // Read the house number
        String cityCheck = reader.readLine();

        if (map.containsKey(cityCheck)) {
            System.out.println(map.get(cityCheck));
        }
    }
}
