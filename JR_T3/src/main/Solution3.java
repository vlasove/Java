package main;

public class Solution3 {
    public static void main(String[] args) {
        try{
            String s = null;
            String m = s.toLowerCase();
        } catch (NullPointerException npe){
            System.out.println(npe);
        }

    }
}
