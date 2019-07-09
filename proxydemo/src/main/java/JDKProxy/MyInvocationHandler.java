package JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*********************************
 * <p> 文件名称: MyInvocationHandler
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：burton.Proxy
 * <p> 功能说明: JDK调用处理器 代理类最后会调用这个类的invoke方法
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/7/3
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public class MyInvocationHandler implements InvocationHandler {

    private Object realImplObject;

    public MyInvocationHandler(Object target) {
        this.realImplObject = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("做真正事情之前，我已经做了。。。");
        Object returnObject = method.invoke(realImplObject, args);
        System.out.println("做真正事情之后，我将要做。。。");
        return returnObject;
    }
}
