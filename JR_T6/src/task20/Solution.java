package task20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> lines = new ArrayList<String>();
    static {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
            String line = reader.readLine();
            while(line != null){
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        System.out.println(lines);
    }
}
