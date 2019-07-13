package com.burton.monthlycalendardemo.monthlyCalendar;

import java.util.Objects;

/**
 * @author Burton
 * @title: CommonUtil
 * @projectName practice-demos
 * @description: TODO
 * @date 2019/7/1314:28
 */
public class CommonUtil {

    /**
     * 判断是否是闰年
     * @param year
     * @return
     */
    public static boolean isRunYear(int year) {
        if ((year%4==0 && year%100!=0) || year%400==0) {
            return true;
        }
        return false;
    }

    /**
     * 得到该月的天数
     * @param month
     * @return
     */
    public static int getDayAmount(int month, boolean isRunYear) {
        Objects.requireNonNull(month);
        //如果是闰年的二月直接返回29天
        if (month == MonthDays.FEBRUARY.getMonthNum() && isRunYear) {
            return MonthDays.FEBRUARY.getDaysAmount() + 1;
        }
        for (MonthDays monthDays : MonthDays.values()) {
            if (month == monthDays.getMonthNum()) {
                return monthDays.getDaysAmount();
            }
        }
        return Integer.parseInt(null);
    }
}
