package main;

import java.util.ArrayList;

public class Solution4 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }

    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> compaund = new ArrayList<String>();
        for(String word : strings){
            String trig1 = "р", trig2 = "л";
            if ((word.contains(trig1) && word.contains(trig2))){
                compaund.add(word);
            } else if(word.contains(trig1)){

            } else if(word.contains(trig2)){
                compaund.add(word);
                compaund.add(word);
            } else {
                compaund.add(word);
            }
        }
        return compaund;
    }


}
