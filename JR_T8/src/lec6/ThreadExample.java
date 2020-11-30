package lec6;

public class ThreadExample extends  Thread {

    public ThreadExample(){
        this.start();
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + " уступает свое место другому!");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " заканчивает выполнение!");
    }

    public static void main(String[] args) {
        for(int i =0 ; i < 5; i++){
            new ThreadExample();
        }
    }
}
