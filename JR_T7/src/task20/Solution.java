package task20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new FourthThread());
        threads.add(new FivethThread());

    }

    public static void main(String[] args) {
    }

    public static class FirstThread extends  Thread{
        public void run(){
            while(true){

            }
        }
    }

    public static class SecondThread extends Thread {
        public void run(){
            try{
                sleep(10000000000000L);
            } catch (InterruptedException ie){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThirdThread extends Thread {
        public void run(){
            while(true){
                try{
                    sleep(500);
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                System.out.println("Ура");
            }
        }
    }

    public static class FourthThread extends  Thread implements Message{
        public void run(){
            try{
                sleep(1000000000000000L);
            }catch (InterruptedException ie){

            }
        }

        @Override
        public void showWarning() {
            if(isAlive())
                interrupt();
        }
    }

    public static class FivethThread extends Thread {
        public void run(){
            int sum = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String line = null;
                try{
                    line = reader.readLine();
                } catch (Exception e){
                    e.printStackTrace();
                }
                if(line.equals("N")){
                    break;
                } else {
                    int num = Integer.parseInt(line);
                    sum += num;
                }
            }
            System.out.println(sum);
        }
    }
}