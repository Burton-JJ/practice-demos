package com.burton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*********************************
 * <p> 模块名称：com.burton
 * <p> 功能说明: 
 * <p> 开发人员：jiangjun
 **********************************/
public class DateParseFormat {
    public static void main(String[] args) throws ParseException {
        String date = "20190806";
        DateFormat inDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date parse = inDateFormat.parse(date);
        inDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String format = inDateFormat.format(parse);
        System.out.println(format);
        System.out.println(System.nanoTime());
    }
}
