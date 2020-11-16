package main;



/*
Конструкторы класса Human
*/

public class Solution20 {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private Integer age = 0;
        private Boolean sex = true;
        private String name = "";
        private String last_name = "";
        private boolean isGay = false;
        private String info = "";
        //1
        public Human(){}
        //2
        public Human(String name){
            this.name = name;
        }
        //3
        public Human(String name, String last_name){
            this.name = name;
            this.last_name = last_name;
        }
        //4
        public Human(String name, String last_name, Integer age){
            this.name = name;
            this.last_name = last_name;
            this.age = age;
        }
        //5
        public Human(String name, String last_name, Integer age, Boolean sex){
            this.name = name;
            this.last_name = last_name;
            this.age = age;
            this.sex = sex;
        }
        //6
        public Human(String name, String last_name, Integer age, Boolean sex, Boolean isGay, String info){
            this.name = name;
            this.last_name = last_name;
            this.age = age;
            this.sex = sex;
            this.isGay = isGay;
            this.info = info;
        }
        //7
        public Human(String name, Integer age){
            this.name = name;
            this.age = age;
        }
        //8
        public Human(String name, Boolean isGay){
            this.name = name;
            this.isGay = isGay;
        }
        //9
        public  Human(Integer age){
            this.age = age;
        }
        //10
        public Human(Boolean sex){
            this.sex = sex;
        }



    }
}