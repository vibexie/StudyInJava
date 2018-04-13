package com.vibexie.studyinjava.utils;

public class TimeCalculate {
    private static long startTime;

    private TimeCalculate() {
    }

    public static void start() {
        startTime = System.nanoTime();
    }

    public static void complete() {
        long consumption = System.nanoTime() - startTime;
        Log.p("--->运算共耗时 %dns <---", consumption);
    }
}