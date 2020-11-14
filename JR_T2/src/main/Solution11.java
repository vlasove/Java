package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution11 {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> nums = new HashSet<>();
        for(int i =0; i < 20; i++){
            nums.add(i);
        }
        return nums;

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Set<Integer> copySet = new HashSet<>();
        copySet.addAll(set);
        Iterator<Integer> iter = copySet.iterator();
        while(iter.hasNext()){
            int elem = iter.next();
            if(elem > 10){
                set.remove(elem);
            }
        }
        return set;
    }

    public static void printSet(Set<Integer> set){
        for(Integer elem : set){
            System.out.println(elem);
        }
    }

    public static void main(String[] args) {
        Set<Integer> set = createSet();
        set = removeAllNumbersGreaterThan10(set);
        printSet(set);
    }
}
