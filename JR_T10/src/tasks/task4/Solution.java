package tasks.task4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/*
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String adv = "JavaRush - курсы Java онлайн";

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        StringBuilder sb = new StringBuilder();
        String[] lines = result.split("\n");
        List<String> linesToPrint = new ArrayList<>();
        for(int i =0; i< lines.length; i++){
            if(i % 2 == 0 && i != 0){
                linesToPrint.add(adv);
            }
            linesToPrint.add(lines[i]);
        }
        for(String line : linesToPrint){
            System.out.println(line);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}