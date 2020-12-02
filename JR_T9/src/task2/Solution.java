package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if(args.length >0) {
            if (args[0].equals("-c")) {
                String productName = args[1];
                String price = args[2];
                String quantity = args[3];
                FileOutputStream stream = new FileOutputStream(fileName, true);


                int maxId = findMaxId(fileName);
                appendToFile(stream, maxId, productName, price, quantity);
                stream.close();
            }
        }
        reader.close();

    }
    public static int findMaxId(String fileName) throws Exception{
        int maxId = 0;
        BufferedReader stream = new BufferedReader(new FileReader(fileName));
        String line = null, last = null;
        while ((line = stream.readLine()) != null) {
            int curId = Integer.parseInt(line.substring(0, 8).trim());
            if(curId > maxId){
                maxId = curId;
            }
        }
        stream.close();
        return maxId;
    }

    public static void appendToFile(FileOutputStream stream, int maxId, String productName, String price, String quantity) throws Exception {
        String ans = "\n" + String.format("%-8s%-30s%-8s%-4s", ++maxId, productName, price, quantity);
        stream.write(ans.getBytes());
    }

}
