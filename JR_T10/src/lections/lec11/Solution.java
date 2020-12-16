package lections.lec11;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        printSomething();

        String result = outputStream.toString();
        System.setOut(consoleStream);
        StringBuilder sb = new StringBuilder(result);
        sb.reverse();
        String reversedString = sb.toString();

        System.out.println(reversedString);
    }
    public static void printSomething(){
        System.out.println("Hi");
        System.out.println("It's me");
        System.out.println("Mario!");
    }
}
