package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution9 {
    public static void main(String[] args) throws  Exception{
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i< 10; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        int ans = findMaxPosled(list);
        System.out.println(ans);
    }

    public static int findMaxPosled(ArrayList<Integer> list){
        int maxPosled = 0;
        for(int i =0; i < list.size() - 1; i++){
            int elem = list.get(i);
            int currentPosled = 1;
            for(int j = i + 1; j < list.size(); j++){

                if(list.get(j) == elem) {
                    currentPosled++;
                } else {
                    break;
                }
            }
            if (currentPosled > maxPosled){
                maxPosled = currentPosled;
            }
        }
        return maxPosled;
    }
}
