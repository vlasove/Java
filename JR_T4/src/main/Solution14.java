package main;
import java.io.*;
import java.util.Scanner;

/*
Чтение файла
*/

public class Solution14 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream stream = new FileInputStream(fileName);
        BufferedInputStream buffer = new BufferedInputStream(stream);
        while (buffer.available() > 0){
            System.out.print(buffer.read());
        }
        stream.close();
        buffer.close();

    }
}
