package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution18 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()){break;}
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //TODO сортировка по одному массиву. Строковые литералы по возрастанию. Числа - по убыванию.
        //Найдем индексы всех чисел и строк
        ArrayList<Integer> intIds = new ArrayList<>();
        ArrayList<Integer> strIds = new ArrayList<>();
        for(int i =0; i < array.length; i++){
            if(isNumber(array[i])){
                intIds.add(i);
            } else{
                strIds.add(i);
            }
        }
        //Сортируем по числам
        for(int j =0; j < intIds.size() - 1; j++){
            for(int k =0; k < intIds.size() -1 - j; k++){
                if (Integer.parseInt(array[intIds.get(k)]) < Integer.parseInt(array[intIds.get(k + 1)])){
                    String temp = array[intIds.get(k)];
                    array[intIds.get(k)] = array[intIds.get(k + 1)];
                    array[intIds.get(k+1)] = temp;
                }
            }
        }
        //Соритруем по строкам
        for(int j =0; j < strIds.size() - 1; j++){
            for(int k =0; k < strIds.size() -1 - j; k++){
                if (isGreaterThan(array[strIds.get(k)], array[strIds.get(k+1)])){
                    String temp = array[strIds.get(k)];
                    array[strIds.get(k)] = array[strIds.get(k + 1)];
                    array[strIds.get(k+1)] = temp;
                }
            }
        }


    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            // есть '-' внутри строки
            if (i != 0 && character == '-') {
                return false;
            }

            // не цифра и не начинается с '-'
            if (!Character.isDigit(character) && character != '-') {
                return false;
            }

            // одиночный '-'
            if (chars.length == 1 && character == '-') {
                return false;
            }
        }

        return true;
    }
}

