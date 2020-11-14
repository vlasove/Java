package main;

import java.util.HashSet;
import java.util.Set;

/*
Set из котов
*/

public class Solution16 {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        cats.remove(cats.iterator().next());
        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<>();
        for(int i =0; i< 3; i++){
            cats.add(new Cat("name" + i));
        }
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for(Cat cat : cats){
            System.out.println(cat);
        }
    }

    // step 1 - пункт 1
    public  static class Cat {
        String name;
        public Cat(String name) {
            this.name = name;

        }
    }
}
