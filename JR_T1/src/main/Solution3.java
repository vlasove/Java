package main;

import java.util.ArrayList;
import java.util.Collections;

public class Solution3 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        Collections.addAll(words, "мама", "мыла", "раму");
        words.add(1, "именно");
        words.add(3, "именно");
        words.add("именно");

        printList(words);
    }
    public static void printList(ArrayList<String> list){
        for(String n : list){
            System.out.println(n);
        }
    }
}
