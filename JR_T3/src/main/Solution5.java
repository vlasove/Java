package main;

import java.util.ArrayList;

public class Solution5 {
    public static void main(String[] args) {
        try {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
