package com.burton;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*********************************
 * <p> 文件名称: CustTest
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：com.burton
 * <p> 功能说明: 转换测试
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/7/30
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public class CustTest {
    public static void main(String[] args) {
        /**
         * 总结：将各种不同类型的变量放入Object中，可以取出来强制转换回去
         */
        String name = "jiangjun";
        int age = 23;
        BigDecimal salery = new BigDecimal("15.222");
        Map<String, Object> manInfo = new HashMap<>();
        manInfo.put("name", name);
        manInfo.put("age", age);
        manInfo.put("salary", salery);

        String name2 = (String) manInfo.get("name");
        System.out.println(name2);
        int age2 = (int) manInfo.get("age");
        System.out.println(age2);
        BigDecimal salary2 = (BigDecimal) manInfo.get("salary");
        System.out.println(salary2);
    }
}
