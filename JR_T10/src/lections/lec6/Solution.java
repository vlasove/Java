package lections.lec6;

import javax.print.DocFlavor;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String firstFileName = new String(), secondFileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try{
            fileReader = new FileReader(firstFileName);
            fileWriter = new FileWriter(secondFileName);
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        try {
            int i = 1;
            while (fileReader.ready()) {
                int currInt = fileReader.read();
                if (i % 2 == 0){
                    fileWriter.write(currInt);
                }
                i++;
            }
            fileReader.close();
            fileWriter.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
