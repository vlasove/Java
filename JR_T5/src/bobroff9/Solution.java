package bobroff9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        long firstNum = Long.parseLong(first);
        long secondNum = Long.parseLong(second);

        if (firstNum <= 0 || secondNum <= 0) {
            throw new Exception();
        }

        long ans = GCD(firstNum, secondNum);
        System.out.println(ans);


    }

    public static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
