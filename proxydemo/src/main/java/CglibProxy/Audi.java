package CglibProxy;

/*********************************
 * <p> 文件名称: Audi
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：burton.Proxy
 * <p> 功能说明: JDK动态代理接口实现类
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/7/3
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public class Audi {

    public void sayMyName() {
        System.out.println("我叫奥迪");
    }


    public void drive() {
        System.out.println("奥迪在飞驰");
    }


    public void driveAtSpeed(int speed) {
        System.out.println("奥迪在飞驰,速度：" + speed + "小时每公里");
    }

    private void doMyThing() {
        System.out.println("我在做我自己的事情");
    }
}
