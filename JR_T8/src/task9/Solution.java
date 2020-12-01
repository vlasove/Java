package task9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = null;
        String secondFileName = null;
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            reader = new BufferedReader(new FileReader(firstFileName));
            String line = reader.readLine();
            while (line != null){
                allLines.add(line);
                line = reader.readLine();;
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            reader = new BufferedReader(new FileReader(secondFileName));
            String line = reader.readLine();
            while(line != null){
                forRemoveLines.add(line);
                line = reader.readLine();;
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            Solution s = new Solution();
            s.joinData();
        } catch (CorruptedDataException ce){
            ce.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            for (String line : forRemoveLines){
                allLines.remove(line);
            }
        } else {
            allLines.clear();
            throw  new CorruptedDataException();
        }
    }
}
