package com.burton;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/*********************************
 * <p> 文件名称: EnumFanxing
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：com.burton
 * <p> 功能说明: 泛型在枚举值使用
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/7/31
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public class EnumFanxing {
    public static void main(String[] args) throws IOException {



    }

    private static <E extends Enum> String getDesc(E e) throws IllegalAccessException, InstantiationException {
        //这个方法不行e.value();

        return null;
    }

    private static String getDesc(SeasonEnum e) {
        //这个方法不行e.value();
        //SeasonEnum.
        return null;
    }

    private static <O extends Father> String getDesc(O o) {
        o.sayMyName();
        return null;
    }
}
