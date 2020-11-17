package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/*
Писатель в файл с консоли
*/

public class Solution15 {
    public static void main(String[] args) throws Exception{
        // Захват с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(fileName));
            while (true){
                String line = reader.readLine();

                if (line.equals("exit")){
                    //Не забыть воткнуть "exit" в файл
                    writer.write("exit");
                    break;
                }
                writer.write(line + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            reader.close();
            writer.close();
        }

    }
}

