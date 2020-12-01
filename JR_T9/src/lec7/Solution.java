package lec7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int count = 0;

        FileInputStream stream = new FileInputStream(fileName);
        while(stream.available() > 0){
            int currentByte = stream.read();
            if (currentByte == 44){
                count++;
            }
        }
        stream.close();
        reader.close();
        System.out.println(count);
    }
}
