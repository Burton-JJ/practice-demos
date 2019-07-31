package com.burton;

/*********************************
 * <p> 文件名称: Father
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：com.burton
 * <p> 功能说明: 
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/7/31
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public class Father {
    private int age;
    private String name;

    public void sayMyName() {
        System.out.println(name);
    }

    public Father(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
