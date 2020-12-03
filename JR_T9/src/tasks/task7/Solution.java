package tasks.task7;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String firstFileName = new String();
        String secondFileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //Сначала вычитываем все в массив byte
        FileInputStream firstInput = null, secondInput = null;
        try {
            firstInput = new FileInputStream(firstFileName);
            secondInput = new FileInputStream(secondFileName);
        } catch (FileNotFoundException ffe) {
            ffe.printStackTrace();
        }

        byte[] bytesFirst = null;
        byte[] bytesSecond = null;
        try {
            bytesFirst = new byte[firstInput.available()];
            bytesSecond = new byte[secondInput.available()];

            firstInput.read(bytesFirst);
            secondInput.read(bytesSecond);

            firstInput.close();
            secondInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Склеиваем два массива в один и записываем в первый файл
        byte[] totalBytes = concatByteArrays(bytesFirst, bytesSecond);

        //Перезаписываем первый файл
        FileOutputStream streamOut = null;
        try {
            streamOut = new FileOutputStream(firstFileName);
            streamOut.write(totalBytes);
            streamOut.close();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static byte[] concatByteArrays(byte[] bytesFirst, byte[] bytesSecond) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] total = null;
        try {
            outputStream.write(bytesSecond);
            outputStream.write(bytesFirst);
            total = outputStream.toByteArray();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }
}
