package word;

/**
 * @author Burton
 * @title: WeekDays
 * @projectName practice-demos
 * @description:SIT-A做了修改
 * @date 2019/7/14 23:36
 */
public enum WeekDays {
    SUNDAY(0, "星期日"),
    MONDAY(1, "星期一"),
    THESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六");

    private int weekDayNum;

    private String weekDayDesc;

    WeekDays(int weekDayNum, String weekDayDesc) {
        this.weekDayNum = weekDayNum;
        this.weekDayDesc = weekDayDesc;
    }

    /**
     * 根据数字判断星期几
     * @param dayNum
     * @return
     */
    public static String getDescByNum(int dayNum) {
        for (WeekDays weekDay : values()) {
            if (dayNum == weekDay.weekDayNum) {
                return weekDay.weekDayDesc;
            }
        }
        return null;
    }

    public int getWeekDayNum() {
        return weekDayNum;
    }

    public void setWeekDayNum(int weekDayNum) {
        this.weekDayNum = weekDayNum;
    }

    public String getWeekDayDesc() {
        return weekDayDesc;
    }

    public void setWeekDayDesc(String weekDayDesc) {
        this.weekDayDesc = weekDayDesc;
    }
}
