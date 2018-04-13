package com.vibexie.studyinjava.IntroductionToAlgorithms.chapter_1;

import com.vibexie.studyinjava.utils.Log;

/**
 * 递归算法
 */
public class Recursion {
    public static void main(String args[]) {
        Log.line();
        Log.title("递归算法 阶乘");
        int data = 6;
        Log.p("计算 %d 的阶乘, 结果为: %d", data, factorial(data));
        Log.line();
    }

    private static long factorial(long n) {
        long sum;
        if (n <= 1) {
            sum= 1;
        } else {
            sum = factorial(n - 1) * n;
        }
        return sum;
    }
}
