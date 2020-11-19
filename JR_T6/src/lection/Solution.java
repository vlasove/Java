package lection;
class Cat{
    public static int age;
    public Cat(){
        Cat.age = 30;
    }
}
public class Solution {
    private static String val = "val";

    public static void main(String[] args) {
        Tiger parent = new Tiger();
        Cat me = new Tiger();

        me.setMyParent(parent);
        Cat myParent = me.getMyParent();
        System.out.println(Cat.age);
    }

    static class Cat{
        public static Integer age;
        public Cat parent;
        Cat(){
            age = 20;
        }
        public Cat getMyParent(){
            System.out.println("getMyParent() in CAT!");
            return this.parent;
        }

        public void setMyParent(Cat parent){
            System.out.println("setMyParent() in CAT!");
            this.parent = parent;
        }
    }

    static class Tiger extends Cat{
        public Tiger getMyParent(){
            System.out.println("getMyParent() in TIGER!!!");
            return (Tiger) this.parent;
        }

    }
}
