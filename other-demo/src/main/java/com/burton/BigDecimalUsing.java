package com.burton;

import java.math.BigDecimal;

/*********************************
 * <p> 文件名称: BigDecimalUsing
 * <p> 模块名称：com.burton
 * <p> 功能说明: Bigdecimal使用踩坑
 * <p> 开发人员：jiangjun
 **********************************/
public class BigDecimalUsing {
    public static void main(String[] args) {
        /**
         * 总结：
         * 创建Bigdecimal要用String
         * 所想要去掉多余的0用stripTrailingZeros方法 但是会导致科学记数法 可以用toPlainString防止科学计数法
         */
        //创建
        //推荐用String创建
//        BigDecimal a = new BigDecimal("12.13");
//        //会失真
//        BigDecimal b = new BigDecimal(12.13);
//        //整数不会失真
//        BigDecimal c = new BigDecimal(12);
//        //以下这种方式与用String是一样的 会装换成String
//        BigDecimal d = BigDecimal.valueOf(12.13);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);

        /**
         * 结果：
         * 12.13
         * 12.1300000000000007815970093361102044582366943359375
         * 12
         * 12.13
         */

//        BigDecimal a = new BigDecimal("100000000000000000000000000.00000000000000000000000000000000000");
//        BigDecimal b = new BigDecimal("12.1300000000000000000000000000010000000000000000000000000");
//        System.out.println(a);
//        System.out.println(b);
//        //用了去掉多余的0的stripTrailingZeros方法后，若是个整数会变成科学记数法
//        System.out.println(a.stripTrailingZeros());//与下面同String一样
//        System.out.println(b.stripTrailingZeros());//与下面同String一样
//        //用了去掉多余的0的stripTrailingZeros方法后，若是个整数会变成科学记数法
//        System.out.println(a.stripTrailingZeros().toString());
//        System.out.println(b.stripTrailingZeros().toString());
//        //toPlainString可以不使用科学计数法
//        System.out.println(a.stripTrailingZeros().toPlainString());
//        System.out.println(b.stripTrailingZeros().toPlainString());

        /**
         * 结果：
         * 100000000000000000000000000.00000000000000000000000000000000000
         * 12.1300000000000000000000000000010000000000000000000000000
         * 1E+26
         * 12.130000000000000000000000000001
         * 1E+26
         * 12.130000000000000000000000000001
         * 100000000000000000000000000
         * 12.130000000000000000000000000001
         */

        //四舍五入 设置小数点位数
//        BigDecimal b = new BigDecimal("12.1300456");
//        //第一个参数为小数点位数
//        BigDecimal c = b.setScale(5,BigDecimal.ROUND_HALF_UP);
//        System.out.println(c);
        /**
         * 结果：
         * 12.13005
         */
        BigDecimal a = new BigDecimal("10.00");
        BigDecimal b = null;
        BigDecimal subtract = a.subtract(b);
        System.out.println(subtract);
    }
}
