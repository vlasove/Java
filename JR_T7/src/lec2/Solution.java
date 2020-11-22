package lec2;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Main thread start working!");
        Thread thread = new Thread(new Rofl());
        System.out.println("Borning thread Rofl");
        thread.start();
        System.out.println("Main thread done!");
    }

    public static class Rofl implements Runnable{
        public void run(){
            System.out.println("Rofl thread start working!");
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e){

            }
            System.out.println("Rofl thread ended!");
        }
    }
}
