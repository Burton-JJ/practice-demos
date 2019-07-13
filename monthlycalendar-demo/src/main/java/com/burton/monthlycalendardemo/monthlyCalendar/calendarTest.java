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
                sum=sum+366;
            }
            else{
                sum=sum+365;
            }
        }
        //统计月份的天数
        for(int i=1;i<month;i++){
            //大月
            if(i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                sum=sum+31;
            }
            //小月
            else if(i==4||i==6||i==9||i==11){
                sum=sum+30;
            }
            //二月
            else {
                if(Renyear)
                    sum=sum+29;
                else
                    sum=sum+28;
            }
        }

        //该公式起始时间是1990年1月1日，且1月1日是星期一。
        int blank=sum%7+1;//blank开始输出的空格数 +1是从星期天开始；
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
