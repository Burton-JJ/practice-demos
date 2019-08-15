package com.burton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

/*********************************
 * <p> 文件名称: EnumFanxing
 * <p> 模块名称：com.burton
 * <p> 功能说明: 泛型在枚举值使用
 * <p> 开发人员：jiangjun
 * <p> 开发时间：2019/7/31
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public class EnumFanxing {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        getDesc(SeasonEnum.AUTURM);
    }

    private static <T extends Enum<T>> String getDesc(T e) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //这个方法不行e.value();
        Enum[] enums = e.getClass().getEnumConstants();
        Method getDesc = e.getClass().getMethod("getDesc");
        for (Enum anEnum : enums) {
            Object invokeReturn = getDesc.invoke(anEnum);
            System.out.println(invokeReturn);
            System.out.println(anEnum.name());
        }
        return null;
    }

//    private static String getDesc(SeasonEnum e) {
//        //这个方法不行e.value();
//        //SeasonEnum.
//        return null;
//    }

    private static <O extends Father> String getDesc(O o) {
        o.sayMyName();
        return null;
    }
}
