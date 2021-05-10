package src.test.MyClassLoader;

/**
 * @Author deng shuo
 * @Date 5/2/21 08:28
 * @Version 1.0
 */
public class CustomerClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw  new ClassNotFoundException(name);
    }

}
