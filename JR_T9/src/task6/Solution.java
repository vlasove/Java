package task6;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = new String();
        String secondFile = new String();
        String thirdFile = new String();
        try{
            firstFile = reader.readLine();
            secondFile = reader.readLine();
            thirdFile = reader.readLine();
            reader.close();

        } catch (IOException ie){
            ie.printStackTrace();
        }

        FileOutputStream output = null;
        FileInputStream inputFirst = null;
        FileInputStream inputSecond = null;
        try {
            output = new FileOutputStream(firstFile, true);
            inputFirst = new FileInputStream(secondFile);
            inputSecond = new FileInputStream(thirdFile);
        } catch (FileNotFoundException fe){
            fe.printStackTrace();
        }
        try {
            byte[] firstContent = new byte[inputFirst.available()];
            inputFirst.read(firstContent);
            output.write(firstContent);

            byte[] secondContent = new byte[inputSecond.available()];
            inputSecond.read(secondContent);
            output.write(secondContent);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            output.close();
            inputFirst.close();
            inputSecond.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
