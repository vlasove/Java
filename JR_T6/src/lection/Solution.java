package lection;

public class Solution {
    private static String val = "val";

    public static void main(String[] args) {
        System.out.println(val);
    }

    public class Bob{
        Bob(){
            System.out.println(val);
        }
    }
}
