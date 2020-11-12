package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution8 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        for(int i =0; i<n;i++){
            list.add(reader.readLine());
        }
        for(int i=0; i<m; i++){
            String cur = list.get(0);
            list.remove(0);
            list.add(cur);
        }
        printList(list);
    }

    public static void printList(ArrayList<String> list){
        for(String word: list){
            System.out.println(word);
        }
    }
}
