package com.vibexie.studyinjava.utils;

import java.util.Arrays;
import java.util.Random;

public class DataGenerator {
    public static int[] randomInts(int counts) {
        if (counts <= 0) {
            return new int[]{};
        }

        Random random = new Random();

        int[] datas = new int[counts];
        for (int i = 0; i < counts; i++) {
            datas[i] = random.nextInt(100);
        }

        Log.p("产生 int[%d] 数据: %s", counts, Arrays.toString(datas));
        return datas;
    }
}
