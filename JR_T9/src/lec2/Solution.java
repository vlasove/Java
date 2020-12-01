package lec2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static String fileName = new String();
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        //create stream
        FileInputStream stream = new FileInputStream(fileName);
        int minByte = Integer.MAX_VALUE;
        while(stream.available() > 0){
            int currentByte = stream.read();
            if (currentByte < minByte){
                minByte = currentByte;
            }
        }
        System.out.println(minByte);
        reader.close();
        stream.close();
    }
}
