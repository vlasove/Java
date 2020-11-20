package task14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/*
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigDecimal bd = new BigDecimal(1);
        if (n < 0) {
            return new Integer(0).toString();
        } else {
            for (int i = 1; i <= n; i++) {
                bd = bd.multiply(new BigDecimal(i));
            }
            return bd.toString();
        }
    }
}

