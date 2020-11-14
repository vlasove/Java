package main;

public class Solution4 {
    public static void main(String[] args) {
        try{
            int[] m = new int[2];
            m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException aioe) {
            System.out.println(aioe);
        }

    }
}
