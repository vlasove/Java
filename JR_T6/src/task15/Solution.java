package task15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String template = null;
        while (true) {
            template = reader.readLine();
            if (template.equals("exit")) {
                break;
            }

            if (template.contains(".")) {
                try{
                    print(Double.parseDouble(template));
                } catch (Exception e){
                    print(template);
                }

            } else {    //convert to IntVals
                int tempVal = 0;
                try {
                    tempVal = Integer.parseInt(template);
                } catch (Exception e){
                    print(template);
                    continue;
                }

                if (tempVal > 0 && tempVal < 128) {
                    print((short) tempVal);
                } else if (tempVal <= 0 || tempVal >= 128) {
                    print(tempVal);
                }
            }
        }

        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
