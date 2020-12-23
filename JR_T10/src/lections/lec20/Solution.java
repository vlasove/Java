package lections.lec20;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            fileName = reader.readLine();
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }



        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }

        StringBuilder contentOfFile = new StringBuilder();
        try{
            while (fileReader.ready()){
                contentOfFile.append(fileReader.readLine());
            }
            fileReader.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        String content = contentOfFile.toString().replace("\r\n", "");
        System.out.println(content);


        String openTag = "<" + args[0];
        String closeTag = "</" + args[0];

        //TODO: implements HTML parser

    }
}
