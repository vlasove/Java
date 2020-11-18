package bobroff8;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add( new java.lang.RuntimeException());
        exceptions.add( new java.lang.IndexOutOfBoundsException());
        exceptions.add( new java.lang.ArrayIndexOutOfBoundsException());
        exceptions.add( new java.lang.ArrayStoreException());
        exceptions.add( new java.lang.ClassCastException());
        exceptions.add( new java.lang.CloneNotSupportedException());
        exceptions.add( new java.lang.ClassNotFoundException());
        exceptions.add( new java.lang.IllegalAccessException());
        exceptions.add( new java.lang.LayerInstantiationException());
        exceptions.add( new java.lang.InstantiationException());

        //напишите тут ваш код

    }
}
