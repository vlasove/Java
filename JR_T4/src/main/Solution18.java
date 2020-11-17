package main;

public class Solution18{

    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    public static class StringObject implements  SimpleObject<String>{
        @Override
        public SimpleObject<String> getInstance() {
            return null;
        }
    }

}