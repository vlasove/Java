package lec10;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String firstOutputFile = reader.readLine();
        String secondOutputFile = reader.readLine();

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream firstOutputStream = new FileOutputStream(firstOutputFile);
        FileOutputStream secondOutputStream = new FileOutputStream(secondOutputFile);
        // a b c d e
        // 0 1 2 3 4
        //5/2 = 2 [0, 2 +1]
        //file1 _>0 1 2
        //file2_> 3 4

        //a b c d
        //0 1 2 3
        //4/2 = 2 [0,

        byte[] buffer = new byte[inputStream.available()];
        byte[] firstBuffer = null;
        byte[] secondBuffer = null;
        int midId = -1;
        if(buffer.length % 2 == 0){
            midId = (buffer.length / 2) ;
        } else {
            midId = (buffer.length / 2) + 1;
        }
        if(inputStream.available() > 0){
            int count = inputStream.read(buffer);
            firstBuffer = Arrays.copyOfRange(buffer, 0, midId);
            secondBuffer = Arrays.copyOfRange(buffer, midId, count);
            firstOutputStream.write(firstBuffer);
            secondOutputStream.write(secondBuffer);
        }

        reader.close();
        inputStream.close();
        firstOutputStream.close();
        secondOutputStream.close();
    }
}
