package lec3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String fileName = new String();
    public static Map<Integer, Integer> counter =  new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        //create stream
        FileInputStream stream = new FileInputStream(fileName);
        while(stream.available() > 0){
            Integer currentByte = stream.read();
            if(counter.containsKey(currentByte)){
                counter.put( currentByte, counter.get(currentByte) + 1);
            } else {
                counter.put(currentByte, 1);
            }
        }
        findMax(counter);

        stream.close();
        reader.close();
    }
    public  static  void findMax(Map<Integer, Integer> map){
        Integer maxValue = Collections.max(map.values());
        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() == maxValue){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
