package lection;

public class Solution {
    private static String val = "val";

    public static void main(String[] args) {
        Tiger parent = new Tiger();
        Cat me = new Tiger();

        me.setMyParent(parent);
        Cat myParent = me.getMyParent();
    }

    static class Cat{
        public Cat parent;
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
