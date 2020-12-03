package tasks.task8;

import java.io.*;

/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        String firstFileName = new String();
        String secondFileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        //Вычитываем из первого файла вещественные числа
        String lineWithFloats = new String();
        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader(firstFileName));
            lineWithFloats = fileReader.readLine();
            fileReader.close();
        } catch (FileNotFoundException ffe){
            ffe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        String[] stringsFloat = lineWithFloats.split("\\s+");
        Float[] floatArray = new Float[stringsFloat.length];
        for(int i =0; i < stringsFloat.length; i++){
            floatArray[i] = Float.parseFloat(stringsFloat[i]);
        }

        //Округляем каждое вещественное число до целого
         Integer[] integerArray = new Integer[floatArray.length];
        for(int i =0; i < floatArray.length; i++){
            integerArray[i] = Math.round(floatArray[i]);
        }
        //Формируем строку для записи - все числа из массива Integer[] разделить пробелами
        String totalString = new String();
        for(int i =0; i< integerArray.length; i++){
            if (i == integerArray.length - 1){
                totalString += Integer.toString(integerArray[i]);
            } else {
                totalString += Integer.toString(integerArray[i]) + " ";
            }
        }
        // Превращаем в byte[]
        byte[] bytesToWrite = totalString.getBytes();

        //Записываем во второй файл
        FileOutputStream streamOut = null;
        try{
            streamOut = new FileOutputStream(secondFileName);
            streamOut.write(bytesToWrite);
            streamOut.close();
        } catch (FileNotFoundException ffe){
            ffe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
