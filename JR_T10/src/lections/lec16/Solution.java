package lections.lec16;

import java.io.*;

/*
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = new String();
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        FileOutputStream writer = null;
        try {
            writer = new FileOutputStream(fileName);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(consoleStream);
        String result = outputStream.toString();
        System.out.println(result);

        try{
            writer.write(result.getBytes());
            writer.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

