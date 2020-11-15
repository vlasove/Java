package main;

public class Solution14 {
    public static int A = 5;
    public static int B = 2 * A;
    public  static int C = A * B;
    public static int D = A * B;

    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        solution.A = 5;

        Solution14.D = 5;
    }

    public int getA() {
        return A;
    }

}
