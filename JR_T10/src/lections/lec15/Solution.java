package lections.lec15;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);

        String result = outputStream.toString();
        Solver expression = parseResult(result);
        expression.solve();
        System.out.println(expression.get_string());
    }

    public static Solver parseResult(String result){
        String[] words = result.split("\\s");
        int firstVal = Integer.parseInt(words[0]);
        int secondVal = Integer.parseInt(words[2]);
        char sign = words[1].charAt(0);
        Solver ans = new Solver(firstVal, secondVal, sign);
        return ans;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    public static class Solver {
        private int firstVal;
        private int secondVal;
        private char sign;
        private int result;
        public Solver(int fv, int sv, char sign){
            this.firstVal = fv;
            this.secondVal = sv;
            this.sign = sign;
        }
        public void solve(){
            switch (this.sign){
                case '+':
                    this.result = this.firstVal + this.secondVal;
                    break;
                case '-':
                    this.result = this.firstVal - this.secondVal;
                    break;
                case '*':
                    this.result = this.firstVal * this.secondVal;
                    break;
            }

        }

        public String get_string(){
            return String.format("%d %c %d = %d", this.firstVal, this.sign, this.secondVal, this.result);
        }



    }
}
