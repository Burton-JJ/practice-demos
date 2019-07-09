package component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author Burton
 * @location：component.JDKProxyTest
 * @title: JDKProxyTest
 * @projectName practice-demos
 * @description:
 * @date 2019/7/2 0:44
 */
public class JDKProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class<?> proxyClass = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(), HelloWorld.class);
//        final Constructor<?> constructors = proxyClass.getConstructor(InvocationHandler.class);
//        final InvocationHandler invocationHandler = new MyInvocationHandler(new HelloWorldImpl());
//        HelloWorld helloWorld = (HelloWorld)constructors.newInstance(invocationHandler);
//        helloWorld.sayHello();

        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //写法二
        HelloWorld helloWorld = (HelloWorld) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(),
                new Class<?>[]{HelloWorld.class}, new MyInvocationHandler(new HelloWorldImpl()));
        helloWorld.sayHello();

    }
}
