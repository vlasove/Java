package task1;

import java.io.*;

/*
Шифровка
*/

public class Solution {
    private static byte key = 1;
    public static void main(String[] args) {
        String fileInput = new String();
        String fileOutput = new String();
        switch (args[0]){
            case "-d":
                System.out.println("Дешифровка");
                fileInput = args[1];
                fileOutput = args[2];
                byte[] encryptedFile = readFromEncrypt(fileInput);
                writeTo(encryptedFile, fileOutput);
                break;
            case "-e":
                System.out.println("Шифровка");
                fileInput = args[1];
                fileOutput = args[2];

                byte[] decodeFile = readFromDecode(fileInput);
                writeTo(decodeFile, fileOutput);
                break;
        }
    }
    public static void writeTo(byte[] encryptedBytes, String fileOutput){
        FileOutputStream stream = null;
        try{
            stream = new FileOutputStream(fileOutput);
        } catch (FileNotFoundException fe){
            fe.printStackTrace();
        }
        try {
            stream.write(encryptedBytes);
            stream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static byte[] readFromEncrypt(String fileInput){
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(fileInput);
        } catch (FileNotFoundException fe){
            fe.printStackTrace();
        }
        byte[] bytes = null;
        try {
            bytes = new byte[stream.available()];
            while (stream.available() > 0) {
                stream.read(bytes);
            }
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] + key);
            }
            stream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }

    public static byte[] readFromDecode(String fileInput){
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(fileInput);
        } catch (FileNotFoundException fe){
            fe.printStackTrace();
        }
        byte[] bytes = null;
        try {
            bytes = new byte[stream.available()];
            while (stream.available() > 0) {
                stream.read(bytes);
            }
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - key);
            }
            stream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }

}

