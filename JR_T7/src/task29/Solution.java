package task29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t2.start();
        //add your code here - добавьте код тут
        t1.join();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends  Thread{
        private String ans = "";
        public void run(){
            try{
                String first = reader.readLine();
                String second = reader.readLine();
                String third = reader.readLine();
                ans += first + " " + second + " " + third;
            } catch (Exception e){

            }
        }
        public void printResult(){
            System.out.println(ans);
        }
    }
}

