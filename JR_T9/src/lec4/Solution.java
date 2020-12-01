package lec4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) throws Exception{
        Map<Integer, Integer> counter =  new HashMap<>();
        String fileName = new String();
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

        stream.close();
        reader.close();


        findMin(counter);


    }
    public  static  void findMin(Map<Integer, Integer> map){
        Integer minValue = Collections.min(map.values());
        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() == minValue){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
