package component;

/**
 * @author Burton
 * @location：component.HelloWorldImpl
 * @title: HelloWorldImpl
 * @projectName practice-demos
 * @description:
 * @date 2019/7/2 0:34
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
