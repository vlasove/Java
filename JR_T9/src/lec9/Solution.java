package lec9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws  Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameInput = reader.readLine();
        String fileNameOutput = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileNameInput);
        FileOutputStream outputStream = new FileOutputStream(fileNameOutput);
        byte[] buffer = new byte[inputStream.available()];
        int count = buffer.length;
        while(inputStream.available() > 0){
            int currentByte = inputStream.read();
            buffer[count-1] = (byte) currentByte;
            count--;
        }
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();
    }
}
