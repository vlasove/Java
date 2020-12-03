package tasks.task12;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = new String();
        while(true){
            try {
                fileName = reader.readLine();
                if(fileName.equals("exit")){
                    break;
                }
                ReadThread rt = new ReadThread(fileName);
                rt.start();
            } catch (IOException ioe){
                ioe.printStackTrace();
                break;
            }
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        @Override
        public void run(){
            FileInputStream stream = null;
            Map<Byte, Integer> map = new HashMap<>();
            try{
                stream = new FileInputStream(this.fileName);
                while(stream.available() > 0){
                    byte b = (byte) stream.read();
                    if(map.containsKey(b)){
                        map.put(b, map.get(b) + 1);
                    } else {
                        map.put(b, 1);
                    }
                }
                stream.close();
            } catch(FileNotFoundException fnfe){
                fnfe.printStackTrace();
            } catch (IOException ioe){
                ioe.printStackTrace();
            }

            //find max byte
            Map.Entry<Byte, Integer> maxEntry = null;
            for(Map.Entry<Byte, Integer> pair : map.entrySet()){
                if(maxEntry == null || pair.getValue().compareTo(maxEntry.getValue()) > 0){
                    maxEntry = pair;
                }
            }
            synchronized (resultMap){
                resultMap.put(fileName, (int) maxEntry.getKey());
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
