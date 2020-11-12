package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1 {
    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        ArrayList<Integer> total = new ArrayList<Integer>();
        ArrayList<Integer> remain3 = new ArrayList<Integer>();
        ArrayList<Integer> remain2 = new ArrayList<Integer>();
        ArrayList<Integer> allRemain = new ArrayList<Integer>();

        for(int i =0; i < 20; i++){
            int val = Integer.parseInt(reader.readLine());
            boolean isGood = false;
            total.add(val);
            if (val % 3 ==0){
                remain3.add(val);
                isGood = true;
            }
            if (val % 2 == 0){
                remain2.add(val);
                isGood = true;
            }
            if(!isGood){
                allRemain.add(val);
            }
        }
        printList(remain3);
        printList(remain2);
        printList(allRemain);


    }


    public static void printList(ArrayList<Integer> list){
        for(Integer n : list){
            System.out.println(n);
        }
    }
}
