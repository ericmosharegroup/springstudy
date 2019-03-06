package org.springstudy.utils;

import org.joda.time.DateTime;

/**
 * Created by sheng on 2019/3/5.
 */
public class DateUtils {

    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HHMISS = "hhmmss";

    public static String getCurrentDate() {
        return DateTime.now().toString(YYYYMMDD);
    }

    public static String getCurrentTime() {
        return DateTime.now().toString(HHMISS);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentDate());
        System.out.println(getCurrentTime());

    }
}
