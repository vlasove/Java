package tasks.task11;

import java.io.*;

/*
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = null;
        while(true){
            try {
                fileName = reader.readLine();
                stream = new FileInputStream(fileName);
                stream.close();
            }catch(FileNotFoundException fnfe){
                System.out.println(fileName);
                break;
            } catch (IOException ioe){
                ioe.printStackTrace();
            }

        }
    }
}
