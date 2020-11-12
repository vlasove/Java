package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution5 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int i =0; i < 10; i++){
            list.add(reader.readLine());
        }
        ArrayList<String> result = doubleValues(list);
    }
    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<String>();
        for(String word : list){
            result.add(word);
            result.add(word);
        }
        return result;
    }

    public static void printList(ArrayList<String> list){
        for(String n : list){
            System.out.println(n);
        }
    }
}
