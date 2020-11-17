package main;
import java.awt.*;

/*
Лисица — это такое животное
*/

public class Solution11 {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();
    }

    public static class Fox {
        public String getName() {
            return "Fox";
        }
    }
}