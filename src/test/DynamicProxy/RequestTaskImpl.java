package src.test.DynamicProxy;

/**
 * @Author deng shuo
 * @Date 4/10/21 08:56
 * @Version 1.0
 */
public class RequestTaskImpl implements RequestTask {
    @Override
    public void request() {
        System.out.println("request task method implement");
    }
}
