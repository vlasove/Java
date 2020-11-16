package main;

public class Solution21 {
    public static int A = 5;
    public static int B = 5;
    public static int C = 5;
    public static int D = 5;

    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        solution.A = 5;
        solution.B = 5 * B;
        solution.C = 5 * C * D;
        Solution21.D = 5 * D * C;

        Solution21.D = 5;
    }

    public int getA() {
        return A;
    }

}
