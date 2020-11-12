package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution6 {
    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int i =0; i< 10; i++){
            list.add(reader.readLine());
        }
        int ans = idChecker(list);
        if (ans != -1) {
            System.out.println(ans);
        }
    }

    public static int idChecker(ArrayList<String> list){
        int id = -1;
        for(int i=0; i< list.size() -1; i++){
            if(list.get(i).length() > list.get(i + 1).length()){
                id = i;
                break;
            }
        }
        return id;
    }
}
