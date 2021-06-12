package src.test;

/**
 * @Author deng shuo
 * @Date 6/11/21 21:05
 * @Version 1.0
 */
public class FloatDouble {

    public static void main(String[] args) {

        System.out.println(1f == 0.999999f);          // false
        System.out.println(1f == 0.9999999f);         // false
        System.out.println(1f == 0.99999999f);        // true
        System.out.println(1f == 0.999999999999f);    // true
    }
}
