package com.vibexie.studyinjava.IntroductionToAlgorithms.chapter_2;

import com.vibexie.studyinjava.utils.DataGenerator;
import com.vibexie.studyinjava.utils.Log;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String args[]) {
        Log.line();
        Log.title("归并排序(MergeSort)");
        int[] sourceDatas = DataGenerator.randomInts(20);
        mergeSortAsc(sourceDatas);
        Log.line();
    }

    private static int[] mergeSortAsc(int[] sourceDatas) {
        int[] datas = sourceDatas;
        sort(datas, 0, datas.length - 1);
        Log.p("升序排序结果为: %s", Arrays.toString(datas));
        return datas;
    }

    private static void sort(int[] datas, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        sort(datas, left, middle);
        sort(datas, middle + 1, right);
        merge(datas, left, middle, right);
    }

    private static void merge(int[] datas, int left, int middle, int right) {
        int[] array = new int[right - left + 1];
        int arrayPoint = 0;
        int leftPoint = left;
        int rightPoint = middle + 1;

        //将较小的数移如array数组
        while (leftPoint <= middle && rightPoint <= right) {
            if (datas[leftPoint] < datas[rightPoint]) {
                array[arrayPoint++] = datas[leftPoint++];
            } else {
                array[arrayPoint++] = datas[rightPoint++];
            }
        }

        //将Left数组剩余的数移入array数组
        while (leftPoint <= middle) {
            array[arrayPoint++] = datas[leftPoint++];
        }

        //将Right数组剩余的数移入array数组
        while (rightPoint <= right) {
            array[arrayPoint++] = datas[rightPoint++];
        }

        //重置datas
        for (int i = 0; i < array.length; i++) {
            datas[i + left] = array[i];
        }
    }
}
