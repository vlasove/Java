package lec1;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Main thread start!");
        Person person1 = new Person("Коля");
        Thread thread1 = new Thread(person1);
        thread1.start();

        Person person2 = new Person("Маша");
        Thread thread2 = new Thread(person2);
        thread2.start();
        System.out.println("Main thread finished!");


    }

    public static class Person implements  Runnable{
        private String name;
        public Person(String name){
            this.name = name;
        }

        public void run(){
            System.out.println("Новый тред. Новый " + this.name);
        }
    }
}
