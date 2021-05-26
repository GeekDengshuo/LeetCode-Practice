package src.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author deng shuo
 * @Date 5/14/21 22:29
 * @Version 1.0
 */
public class AtomicTest {

    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase(){
        race.incrementAndGet();
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[THREAD_COUNT];

        for(int i= 0; i< THREAD_COUNT;i++){
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount() >2){
            Thread.yield();
        }

        System.out.println(race);
    }

}
