package com.vibexie.studyinjava.IntroductionToAlgorithms.chapter_2;

import com.vibexie.studyinjava.utils.DataGenerator;
import com.vibexie.studyinjava.utils.Log;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String args[]) {
        Log.line();
        Log.title("插入排序(InsertionSort)");

        int[] sourceDatas = DataGenerator.randomInts(30);
        insertionSortAsc(sourceDatas);
        insertionSortDesc(sourceDatas);

        Log.line();
    }

    //升序
    private static int[] insertionSortAsc(int[] sourceDatas) {
        int[] datas = sourceDatas;
        for (int j = 1; j < datas.length; j++) {
            int key = datas[j];
            int i = j - 1;
            while (i >= 0 && datas[i] > key) {
                datas[i + 1] = datas[i];
                i--;
            }
            datas[i + 1] = key;
        }

        Log.p("升序排序结果为: %s", Arrays.toString(datas));
        return datas;
    }

    //降序
    private static int[] insertionSortDesc(int[] sourceDatas) {
        int[] datas = sourceDatas;
        for (int j = 1; j < datas.length; j++) {
            int key = datas[j];
            int i = j - 1;
            while (i >= 0 && datas[i] < key) {
                datas[i + 1] = datas[i];
                i--;
            }
            datas[i + 1] = key;
        }

        Log.p("降序排序结果为: %s", Arrays.toString(datas));
        return datas;
    }
}