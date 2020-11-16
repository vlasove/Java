package main;


import java.util.ArrayList;
import java.util.Arrays;

public class Solution22 {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> [] ans = new ArrayList[3];
        ans[0] = new ArrayList<String>(Arrays.asList("n", "b"));
        return ans;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String string : list) {
                System.out.println(string);
            }
        }
    }
}
