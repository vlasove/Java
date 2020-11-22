package task15;

import javax.swing.*;

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();

        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //Thread thread = currentThread();
            while (!isInterrupted() && numSeconds > 0) {
                System.out.print(numSeconds + " ");
                numSeconds -= 1;
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    //e.printStackTrace();
                    System.out.println("Прервано!");
                    return;
                }
                //add your code here - добавь код тут
            }
            if (numSeconds == 0){
                System.out.println("Марш!");
            }
        }
    }
}