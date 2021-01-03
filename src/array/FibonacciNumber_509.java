package src.array;

/**
 * @Author deng shuo
 * @Date 2021/1/4 21:50
 * @Version 1.0
 */
public class FibonacciNumber_509 {

    // fibonacci sequence
    // f(0) = 0 ; f(1) = 1 ; f(n) = f(n-1) + f(n-2)
    // 0 =< n <= 30
    public static int fibonacci_recursion(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        return fibonacci_recursion(n-1)+fibonacci_recursion(n-2);
    }

    public static int fibonacci_iteration(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int first = 1;
        int second = 1;
        int result = 0;
        while(n >=3){
            result = first + second;
            first = second;
            second = result;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 30;
        long start_time = System.nanoTime();
        int result = fibonacci_recursion(n);
        long end_time = System.nanoTime();
        System.out.println(result);
        System.out.println("fibonacci_recursion("+n+") ="+(end_time -start_time)+"ns");

        long start_time2 = System.nanoTime();
        int result2 = fibonacci_iteration(n);
        long end_time2 = System.nanoTime();
        System.out.println(result2);
        System.out.println("fibonacci_recursion("+n+") ="+(end_time2 -start_time2)+"ns");


    }
}
