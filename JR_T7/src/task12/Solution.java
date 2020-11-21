package task12;

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 59, 57);
        Thread.sleep(9000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {
            //add your code here - добавь код тут

            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
            }
            Thread.sleep(1000);
            int amount_seconds = hours * 60 * 60 + minutes*60 + seconds;
            amount_seconds++;
            int new_hours = amount_seconds / (60*60);
            int new_minutes = (amount_seconds - new_hours*60*60 )/60;
            int new_seconds = (amount_seconds - new_hours*60*60 - new_minutes*60);

            if(new_seconds >= 60){
                new_minutes++;
                new_seconds = 0;
            }
            if(new_minutes >= 60){
                new_hours++;
                new_minutes = 0;
            }
            if(new_hours >= 24){
                new_hours =0;
            }

            hours = new_hours;
            minutes = new_minutes;
            seconds = new_seconds;

        }
    }
}
