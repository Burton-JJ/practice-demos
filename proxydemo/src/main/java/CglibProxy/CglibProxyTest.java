package CglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author Burton
 * @location：CglibProxy.CglibProxyTest
 * @title: CglibProxyTest
 * @projectName practice-demos
 * @description:
 * @date 2019/7/10 0:41
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        //System.getProperty("user.dir"); 得到项目路径  E:\IDEA Files\My_Projects\practice-demos
        String path = System.getProperty("user.dir") + "\\proxydemo\\src\\main\\java\\CglibProxy";
        //将cglib生成的代理类报错到path路径下
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);
        //实例化一个增强器，也就是cglib中的一个class generator
        Enhancer eh = new Enhancer();
        //设置目标类
        eh.setSuperclass(Audi.class);
        // 设置拦截对象
        eh.setCallback(new Interceptor());
        // 生成代理类并返回一个实例
        Audi audi = (Audi) eh.create();
        audi.sayMyName();
        audi.drive();
        audi.driveAtSpeed(20);

    }
}
