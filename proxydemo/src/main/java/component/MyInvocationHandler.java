package component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Burton
 * @location：component.MyInvocationHandler
 * @title: MyInvocationHandler
 * @projectName practice-demos
 * @description: 调用处理器
 * @date 2019/7/2 0:38
 */
public class MyInvocationHandler implements InvocationHandler{
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method:" + method.getName() + "is invoked!");
        return method.invoke(target, args);
    }
}
