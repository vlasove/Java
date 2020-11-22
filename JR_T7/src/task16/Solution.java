package task16;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread tt = new TestThread();
        tt.start();
        tt.interrupt();

    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        public void run(){

        }
    }
}