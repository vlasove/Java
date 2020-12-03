package tasks.task10;

import java.awt.desktop.ScreenSleepEvent;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String stringId = args[0];
        String fileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //File reader
        BufferedReader fileReader = null;
        String info = new String();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            while ((info = fileReader.readLine()) != null) {
                if (info.startsWith(stringId) && info.substring(0, stringId.length()).equals(stringId) && info.charAt(stringId.length()) == ' ') {
                    break;
                }
            }
            fileReader.close();
        } catch (FileNotFoundException ffe) {
            ffe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println(info);
    }
}
