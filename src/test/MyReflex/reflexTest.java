package src.test.MyReflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author deng shuo
 * @Date 5/4/21 07:54
 * @Version 1.0
 */
public class reflexTest {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException,
            NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Person p = new Person();

        Class clazzGet = p.getClass();
        Class clazzClass = Person.class;

        Class clazzForName = Class.forName("src.test.MyReflex.Person");

//        System.out.println("clazzGet = "+ clazzGet);
//        System.out.println("clazzClass = "+ clazzClass);
//        System.out.println("clazzForName = "+ clazzForName);
//
//        System.out.println(clazzClass == clazzForName);

        System.out.println("class name = "+clazzClass.getName());

        Method fields = clazzClass.getMethod("setAge",int.class);
//        for(Field field:fields){
//            System.out.println(field.getName());
//        }
        System.out.println(fields.getName());

        Person pp = (Person) Class.forName("src.test.MyReflex.Person").getDeclaredConstructor().newInstance();
    }
}
