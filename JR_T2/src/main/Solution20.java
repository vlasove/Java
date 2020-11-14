package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution20 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String before = findFirstSpaces(string);
        String after = findLastSpaces(string);
        string = string.trim();
        //напишите тут ваш код
        String[] words = string.split("\\s+");
        String ans = new String();
        for(int i=0; i<words.length; i++){
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);

        }
        System.out.println(before + String.join(" ", words) + after);

    }
    public static String findFirstSpaces(String string){
        String ans = new String();
        for(int i=0; i< string.length() - 1; i++) {
            if (string.charAt(i) == ' ' && string.charAt(i + 1) == ' ') {
                ans += " ";
            } else {
                ans += " ";
                break;
            }
        }
        return ans;
    }

    public static String findLastSpaces(String string){
        String ans = new String();
        for(int i=string.length() -1; i >= 1; i--) {
            if (string.charAt(i) == ' ' && string.charAt(i - 1) == ' ') {
                ans += " ";
            } else {
                ans += " ";
                break;
            }
        }
        return ans;
    }
}
