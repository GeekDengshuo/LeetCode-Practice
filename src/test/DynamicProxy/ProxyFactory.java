package src.test.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @Author deng shuo
 * @Date 4/10/21 09:03
 * @Version 1.0
 */
public class ProxyFactory {

    public static Object getInstance(Object obj){
        return Proxy.newProxyInstance(RequestTaskImpl.class.getClassLoader(),
                                      RequestTaskImpl.class.getInterfaces(),
                                      new TaskInvocationHandler(obj));
    }
}
