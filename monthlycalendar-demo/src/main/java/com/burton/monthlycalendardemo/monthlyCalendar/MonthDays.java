package com.burton.monthlycalendardemo.monthlyCalendar;

/**
 * @author Burton
 * @title: MonthDays
 * @projectName practice-demos
 * @description: TODO
 * @date 2019/7/1314:01
 */
public enum MonthDays {
    /**
     * 闰年2月29天放到真实用到的时候特殊处理 比如CommonUtil类里的方法
     */
    JANUARY(1, 31, "一月"),
    FEBRUARY(2, 28, "二月"),
    MARCH(3, 31, "三月"),
    APRIL(4, 30, "四月"),
    MAY(5, 31, "五月"),
    JUNE(6, 30, "六月"),
    JULY(7, 31, "七月"),
    AUGUST(8, 31, "八月"),
    SEPTEMBER(9, 30, "九月"),
    OCTOBER(10, 31, "十月"),
    NOVEMBER(11, 30, "十一月"),
    DECEMBER(12, 31, "十二月");

    /**
     * 月份数字
     */
    private int monthNum;
    /**
     * 当月天数
     */
    private int daysAmount;
    /**
     * 月份描述
     */
    private String monthDescription;

    MonthDays(int monthNum, int daysAmount, String monthDescription) {
        this.daysAmount = daysAmount;
        this.monthDescription = monthDescription;
        this.monthNum = monthNum;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(int monthNum) {
        this.monthNum = monthNum;
    }

    public int getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(int daysAmount) {
        this.daysAmount = daysAmount;
    }

    public String getMonthDescription() {
        return monthDescription;
    }

    public void setMonthDescription(String monthDescription) {
        this.monthDescription = monthDescription;
    }
}
