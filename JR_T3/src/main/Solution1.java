package main;

public class Solution1 {
    public static void main(String[] args) {
        method1();
    }

    public static String method1() {
        method2();
        StackTraceElement name = Thread.currentThread().getStackTrace()[2];
        return name.getMethodName();
    }

    public static String method2() {
        method3();
        //напишите тут ваш ко
        StackTraceElement name = Thread.currentThread().getStackTrace()[2];
        return name.getMethodName();
    }

    public static String method3() {
        method4();
        StackTraceElement name = Thread.currentThread().getStackTrace()[2];
        return name.getMethodName();
    }

    public static String method4() {
        method5();
        StackTraceElement name = Thread.currentThread().getStackTrace()[2];
        return name.getMethodName();
    }

    public static String method5() {
        StackTraceElement name = Thread.currentThread().getStackTrace()[2];
        return name.getMethodName();
    }
}