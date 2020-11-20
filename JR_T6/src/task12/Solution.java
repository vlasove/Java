package task12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(stream);
        try {
            String line = reader.readLine();
            if (line.equals("helicopter")) {
                result = new Helicopter();
            } else if (line.equals("plane")) {
                int amount = Integer.parseInt(reader.readLine());
                result = new Plane(amount);
            }
            reader.close();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

