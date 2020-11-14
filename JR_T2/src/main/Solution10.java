package main;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution10 {
    public static Set<String> createSet() {
        //напишите тут ваш код
        Set<String> words = new HashSet<>();
        Collections.addAll(words, "Л", "ЛЛ", "ЛЛЛ","ЛЛЛЛ","ЛЛЛЛЛ", "ЛЛЛЛЛЛ","Л1","Л2","Л3", "Л4");
        Collections.addAll(words, "Л5", "Л6", "Л7", "Л8", "Л9", "Л10", "Л11", "Л12" , "Л13", "Л13", "Л14");
        return  words;

    }

    public static void main(String[] args) {
        Set<String> s = createSet();
        System.out.println(s.size());
    }
}

