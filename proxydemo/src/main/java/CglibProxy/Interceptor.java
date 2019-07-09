package CglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Burton
 * @location：CglibProxy.Interceptor
 * @title: Interceptor
 * @projectName practice-demos
 * @description:
 * @date 2019/7/10 0:34
 */
public class Interceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("做真正事情之前，我已经做了。。。");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("做真正事情之后，我将要做。。。");
        return result;
    }
}
