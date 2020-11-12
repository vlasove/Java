package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution9 {
    public static void main(String[] args) throws Exception{
        int[] nums = getInts();
        int maximum = nums[0];
        int minimum = nums[0];
        for(int i =1; i < nums.length; i++){
            if(nums[i] > maximum){
                maximum = nums[i];
            }
            if (nums[i] < minimum){
                minimum = nums[i];
            }
        }

        System.out.println(maximum + " " + minimum);
    }

    public static int[] getInts() throws Exception{
        int[] nums = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i< 20; i++){
            nums[i] = Integer.parseInt(reader.readLine());
        }
        return nums;
    }
}
