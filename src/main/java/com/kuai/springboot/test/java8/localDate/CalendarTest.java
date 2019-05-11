package com.kuai.springboot.test.java8.localDate;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc 实现日历的功能.
 * @since 2019/5/11
 */
public class CalendarTest {

    // 入口
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int dayOfMonth = now.getDayOfMonth();

        LocalDate start = now.minusDays(dayOfMonth - 1);
        DayOfWeek dayOfWeek = start.getDayOfWeek();
        int value = dayOfWeek.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        for (int j = 1; j <= 31; j++) {
            LocalDate date = now.minusDays(dayOfMonth - j);
            int thatDay = date.getDayOfMonth();
            System.out.printf("%3d",thatDay);
            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }

}