package lec1;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static String fileName = new String();

    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        //create stream
        int maxByte = Integer.MIN_VALUE;
        FileInputStream stream = new FileInputStream(fileName);
        while(stream.available() > 0){
            int currentByte = stream.read();
            if (currentByte > maxByte){
                maxByte = currentByte;
            }
        }
        System.out.println(maxByte);

        reader.close();
        stream.close();
    }
}
