package com.burton;

import java.util.ArrayList;
import java.util.List;

/*********************************
 * <p> 文件名称: ListSublist
 * <p> 模块名称：com.burton
 * <p> 功能说明: 关于List的sublist的坑
 * <p> 开发人员：jiangjun
 **********************************/
public class ListSublist {
    public static void main(String[] args) {
        List<Integer> fatherList = new ArrayList<>(3);
        fatherList.add(1);
        fatherList.add(2);
        fatherList.add(3);
        //前闭后开
        List<Integer> sonList = fatherList.subList(0,2);
        System.out.println(fatherList);
        System.out.println(sonList);

        //修改父list中的一个值 也会对子list产生影响
//        fatherList.set(0,2);
//        System.out.println(fatherList);
//        System.out.println(sonList);

        //修改子list中的一个值 也会对父list产生影响
//        sonList.set(0,2);
//        System.out.println(fatherList);
//        System.out.println(sonList);

        //子list删除或增加一个元素 夫list也会相应改变 且对应的顺序也是影响的
//        sonList.add(4);
//        sonList.remove(1);
//        System.out.println(fatherList);
//        System.out.println(sonList);

        //父list删除或增加一个元素 报错
//        fatherList.add(4);
//        System.out.println(fatherList);
//        System.out.println(sonList);
    }
}
