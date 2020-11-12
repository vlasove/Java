package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution7 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i =0; i< 10; i++){
            nums.add(Integer.parseInt(reader.readLine()));
        }

        for(int i = nums.size() -1; i >= 0; i--){
            System.out.println(nums.get(i));
        }
    }
}
