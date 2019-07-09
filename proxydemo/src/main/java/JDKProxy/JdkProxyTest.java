package JDKProxy;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/*********************************
 * <p> 文件名称: JdkProxyTest
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：burton.Proxy
 * <p> 功能说明: JDK动态代理测试
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/7/3
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public class JdkProxyTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, IOException {
        Car realSubject = new Audi();
        //将生成的代理类保存到本地
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        //1.0 获取代理类的类对象，主要设置相同的ClassLoader去加载目标类实现的接口Subject类
        Class<?> proxyClass = Proxy.getProxyClass(JdkProxyTest.class.getClassLoader(), new Class[]{Car.class});
        System.out.println(proxyClass);
        //2.0 得到代理类后，就可以通过代理类的处理器句柄来得到构造器
        final Constructor<?> con = proxyClass.getConstructor(InvocationHandler.class);
        //3.0 获取具体执行方法的句柄处理器，目的通过构造器传入被代理目标类对象，注入到代理类处理器句柄中进行代理调用
        final InvocationHandler handler = new MyInvocationHandler(realSubject);
        //4.0 通过构造器创建代理类对象
        Car car = (Car) con.newInstance(handler);

        //5.0 最后调用方法
        car.sayMyName();
        car.drive();
        car.driveAtSpeed(20);


    }
}

