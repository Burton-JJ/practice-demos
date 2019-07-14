package com.burton.monthlycalendardemo.monthlyCalendar;

import java.util.Scanner;

public class calendarTest {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("选择年份(注必须大于1990年):");
        int year=input.nextInt();
        System.out.println("选择该年月份：");
        int month=input.nextInt();
        //先判断year是否是闰年
        boolean Renyear;//定义布尔类型true or false
        if(CommonUtil.isRunYear(year)){
            System.out.println(year+"是闰年");
            Renyear=true;
        }
        else{
            System.out.println(year+"是平年");
            Renyear=false;
        }
        //记录当月的天数
        int day = CommonUtil.getDayAmount(month, Renyear);
        System.out.print(year+"年"+month+"月"+"有"+day+"天"+"\t");
        System.out.println(month+"月份的万年历如下：");
        //统计从1990年到指定日期的天数，1990年1月1日为星期一。
        int sum=0;
        //从1990年开始循环，循环次数是：指定年份—1990；
        for(int i=1990;i<year;i++){
            //判断是否是闰年
            if(CommonUtil.isRunYear(year)){
                sum +=366;
            }
            else{
                sum += 365;
            }
        }
        //统计月份的天数
        for(int i=1;i<month;i++){
            int dayAmount = CommonUtil.getDayAmount(i, Renyear);
            sum += dayAmount;
        }

        //该公式起始时间是1990年1月1日，且1月1日是星期一。
        //int blank=sum%7的结果代表我们要计算的月的前一个月最后一天是星期几
        int blank=sum%7+1;//blank开始输出的空格数 也代表当前月的第一天是星期几
        System.out.println("---------------");
        System.out.println(blank);
        System.out.println("星期天\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");

        int temp=1;
        for(int i=0;i<blank;i++){
            System.out.print("\t");
            temp++;
        }
        if(temp>7){
            System.out.println("");
            temp=1;
        }
        for(int i=1;i<=day;i++){
            if(temp%7==0){
                System.out.print(i+"\n");//控制换行
                temp=1;
            }
            else{
                System.out.print(i+"\t");
                temp++;
            }
        }

    }
}
