package main;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "арбуз", "банан", "вишня", "груша", "дыня", "ежевика", "женьшень","земляника", "ирис", "картофель");
        for(String word : set){
            System.out.println(word);
        }
    }
}
