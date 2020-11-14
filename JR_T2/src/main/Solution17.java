package main;

import java.util.HashSet;
import java.util.Set;

/*
Множество всех животных
*/

public class Solution17 {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        //Возвращает мн-во с 4 котами
        Set<Cat> result = new HashSet<Cat>();
        for(int i =0; i<4; i++){
            result.add(new Cat());
        }
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        //Возвращает мн-во с 3 собаками
        Set<Dog> result = new HashSet<>();
        for(int i=0; i<3; i++){
            result.add(new Dog());
        }
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        //комбинирует 2 мн-ва в одно
        Set<Object> pets = new HashSet<>();
        for(Cat cat: cats){
            pets.add(cat);
        }
        for(Dog dog: dogs){
            pets.add(dog);
        }
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        //Удаляет всех котов cats из pets
        //Set<Object> copyPets = new HashSet<>(pets);
        for(Cat cat : cats){
            if(pets.contains(cat)){
                pets.remove(cat);
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        //Выводит всех котов с новой строки
        for(Object pet: pets){
            System.out.println(pet);
        }
    }

    //напишите тут ваш код
    public static class Cat{
        public Cat(){}
    }

    public static class Dog{
        public Dog(){}
    }
}