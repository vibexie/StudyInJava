package com.vibexie.studyinjava.utils;

public class Log {
    public static void p(String format, Object... objects) {
        System.out.println(String.format(format, objects));
    }

    public static void line() {
        p("##########################################################################");
    }

    public static void title(String title) {
        p("                            %s                            ", title);
    }
}
