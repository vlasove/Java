package tasks.task3;

import java.io.*;

/*
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = new String();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            String content = new String();
            while((content = in.readLine()) != null){
                System.out.println(new StringBuilder(content).reverse().toString());
            }

        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
