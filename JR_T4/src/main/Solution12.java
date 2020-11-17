package main;

import java.awt.*;

/*
Большая лисица — это такая лисица
*/

public class Solution12 {

    public static void main(String[] args) throws Exception {
        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());

    }

    public interface Animal {
        Color getColor();
    }

    public static abstract class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
    //TODO: Исправить этот класс, что-то тут не чисто
    public static class BigFox extends Fox {
        public Color() {
            return Color.GRAY;
        }
    }

}

