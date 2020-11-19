package task11;

public class Solution {
    public static Cat cat;
    static {
        cat = new Cat();
        cat.name = "";
        System.out.println(cat.name);
    }

    public static class Cat{
        public String name;
    }

    public static void main(String[] args) {

    }
}

