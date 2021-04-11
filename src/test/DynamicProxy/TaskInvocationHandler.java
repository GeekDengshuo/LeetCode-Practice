package src.test.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author deng shuo
 * @Date 4/10/21 08:57
 * @Version 1.0
 */
public class TaskInvocationHandler implements InvocationHandler {

    private Object object;

    public TaskInvocationHandler(){

    }

    public TaskInvocationHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        if(method.getName().equals("request")){
            // pre
            System.out.println("invocationHandler wrapper before request function");
            result = method.invoke(object,args);
            // after
            System.out.println("invocationHandler wrapper after");
        }
        return result;
    }
}
