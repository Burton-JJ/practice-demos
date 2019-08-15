package com.burton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*********************************
 * <p> 文件名称: DateParseFormat
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：com.burton
 * <p> 功能说明: 
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/8/7
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
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
