package src.test.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author deng shuo
 * @Date 4/10/21 09:05
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {

        RequestTask requestTask = new RequestTaskImpl();

        InvocationHandler invocationHandler = new TaskInvocationHandler(requestTask);

        // must implement RequestTaskImpl all interface
        RequestTask proxy = (RequestTask) Proxy.newProxyInstance(RequestTaskImpl.class.getClassLoader(),
                RequestTaskImpl.class.getInterfaces(),invocationHandler);

        proxy.request();


        RequestTask requestTask1 = (RequestTask) ProxyFactory.getInstance(new RequestTaskImpl());

        requestTask1.request();

    }
}
