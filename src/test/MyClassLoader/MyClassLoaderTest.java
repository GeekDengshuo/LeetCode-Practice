package src.test.MyClassLoader;

/**
 * @Author deng shuo
 * @Date 5/1/21 18:54
 * @Version 1.0
 */
public class MyClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        ClassLoader parentClassLoader = classLoader.getParent();

        ClassLoader rootClassLoader = parentClassLoader.getParent();

        System.out.println(classLoader);

        System.out.println(parentClassLoader);

        //System.out.println(rootClassLoader);
    }
}
