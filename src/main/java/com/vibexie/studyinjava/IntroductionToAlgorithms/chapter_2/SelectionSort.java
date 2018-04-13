package com.vibexie.studyinjava.IntroductionToAlgorithms.chapter_2;

import com.vibexie.studyinjava.utils.DataGenerator;
import com.vibexie.studyinjava.utils.Log;

import java.util.Arrays;

/**
 * 选择排序
 * Exercise 2.2.2
 */
public class SelectionSort {
    public static void main(String args[]) {
        Log.line();
        Log.title("选择排序(SelectionSort)");
        int[] sourceDatas = DataGenerator.randomInts(20);
        selectinoSortAsc(sourceDatas);
        selectinoSortDesc(sourceDatas);

        Log.line();
    }

    private static int[] selectinoSortAsc(int[] sourceDatas) {
        int[] datas = sourceDatas;
        for (int i = 0; i < datas.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < datas.length; j ++) {
                if (datas[j] < datas[min]) {
                    min = j;
                }
            }
            int temp = datas[i];
            datas[i] = datas[min];
            datas[min] = temp;
        }
        Log.p("升序排序结果为: %s", Arrays.toString(datas));
        return datas;
    }

    private static int[] selectinoSortDesc(int[] sourceDatas) {
        int[] datas = sourceDatas;
        for (int i = 0; i < datas.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < datas.length; j ++) {
                if (datas[j] > datas[min]) {
                    min = j;
                }
            }
            int temp = datas[i];
            datas[i] = datas[min];
            datas[min] = temp;
        }
        Log.p("降序排序结果为: %s", Arrays.toString(datas));
        return datas;
    }
}
