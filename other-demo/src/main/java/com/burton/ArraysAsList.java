package com.burton;

import java.util.Arrays;
import java.util.List;

/*********************************
 * <p> 文件名称: ArraysAsList
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：com.burton
 * <p> 功能说明: arrays.asList采坑
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/7/27
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public class ArraysAsList {
    public static void main(String[] args) {
//        Integer[] myInteger = new Integer[3];
//        myInteger[0] = 1;
//        myInteger[1] = 2;
//        myInteger[2] = 3;
        Integer[] myInteger = {1,2,3};
        System.out.println(myInteger);

        //重新设置数值 获取长度都可以
        List<Integer> integers = Arrays.asList(myInteger);
        System.out.println(integers);
        integers.set(0, 4);
        System.out.println(integers.size());
        System.out.println(integers);

        //不可以add remove
        integers.add(5);
        System.out.println(integers);
    }
}
