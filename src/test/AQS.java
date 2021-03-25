package src.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author deng shuo
 * @Date 3/21/21 15:17
 * @Version 1.0
 */
public class AQS {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(1);


    }
}
