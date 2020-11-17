package main;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The index of the minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        int min = copy[0];
        int min_id = -1;
        for(int i =0; i < array.length; i++){
            if(array[i] == min){
                min_id = i;
            }
        }

        return new Pair(min, min_id);


        //напишите тут ваш код

    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}