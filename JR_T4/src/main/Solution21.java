package main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution21 {

    public static FileInputStream fileStream = null;
    public static BufferedInputStream fileBuffer = null;
    public static BufferedReader r = null;

    public static void main(String[] args) throws  Exception{
        //Получаем название файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //Наполняем список чисел
        List<Integer> nums = new ArrayList<>();
        try{
            fileStream = new FileInputStream(fileName);
            fileBuffer = new BufferedInputStream(fileStream);
            r = new BufferedReader(new InputStreamReader(fileBuffer, StandardCharsets.UTF_8));
            String line = r.readLine();
            while(line != null){
                int val = Integer.parseInt(line);
                if(val % 2 == 0){
                    nums.add(val);
                }
                //System.out.println(line);
                line = r.readLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            fileStream.close();
            fileBuffer.close();
            r.close();
        }

        Collections.sort(nums);
        for(Integer val : nums){
            System.out.println(val);
        }

    }
}
