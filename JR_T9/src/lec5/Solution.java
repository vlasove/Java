package lec5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Set<Integer> setBytes = new HashSet<>();
        FileInputStream stream = new FileInputStream(fileName);
        while (stream.available() > 0){
            Integer currentByte = stream.read();
            setBytes.add(currentByte);
        }
        List<Integer> lstBytes = new ArrayList<>(setBytes);
        Collections.sort(lstBytes);

        reader.close();
        stream.close();
        for(Integer val : lstBytes){
            System.out.print(val + " ");
        }

    }
}
