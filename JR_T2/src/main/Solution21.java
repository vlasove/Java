package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Собираем семейство
*/

public class Solution21 {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human son1 = new Human();
        son1.name = "son1";
        son1.sex = true;
        son1.children = new ArrayList<>();

        Human son2 = new Human();
        son2.name = "son2";
        son2.sex = true;
        son2.children = new ArrayList<>();

        Human son3 = new Human();
        son3.name = "son3";
        son3.sex = true;
        son3.children = new ArrayList<>();

        Human mom = new Human();
        mom.name = "mom";
        mom.sex = false;
        mom.children = new ArrayList<>(Arrays.asList(son1, son2, son3));

        Human dad = new Human();
        dad.name = "dad";
        dad.sex = true;
        dad.children = new ArrayList<>(Arrays.asList(son1, son2, son3));


        Human granny1 = new Human();
        granny1.name = "granny1";
        granny1.sex = false;
        granny1.children = new ArrayList<>(Arrays.asList(mom));

        Human granddad1 = new Human();
        granddad1.name = "granddad1";
        granddad1.sex = true;
        granddad1.children = new ArrayList<>(Arrays.asList(mom));


        Human granny2 = new Human();
        granny2.name = "granny2";
        granny2.sex = false;
        granny2.children = new ArrayList<>(Arrays.asList(dad));

        Human granddad2 = new Human();
        granddad2.name = "granddad2";
        granddad2.sex = true;
        granddad2.children = new ArrayList<>(Arrays.asList(dad));


        ArrayList<Human> humans = new ArrayList<>(Arrays.asList(granddad1, granny1, granddad2, granny2, dad, mom, son1, son2, son3));

        for(Human human : humans){
            System.out.println(human.toString());
        }




    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
