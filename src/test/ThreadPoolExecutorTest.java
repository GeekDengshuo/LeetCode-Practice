package src.test;

/**
 * @Author deng shuo
 * @Date 4/3/21 16:07
 * @Version 1.0
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 大小测试
 */
public class ThreadPoolExecutorTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int COUNT_MASK = (1<<COUNT_BITS) -1;
    private static final int RUNNING  = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0  << COUNT_BITS;
    private static final int STOP     = 1 << COUNT_BITS;
    private static final int TIDYING  = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING,0));
    private int ctlOf(int runState,int workerCount){ return runState | workerCount; }
    private int getWorkerCount(int ctl){ return ctl & COUNT_MASK;}
    private int getRunState(int ctl){ return ctl & ~COUNT_MASK; }


    public static void main(String[] args) {

        System.out.println("COUNT_BITS = "+COUNT_BITS);
        System.out.println("COUNT_BITS = "+Integer.toBinaryString(COUNT_BITS));
        System.out.println("COUNT_MASK = "+COUNT_MASK);
        System.out.println("COUNT_MASK = "+Integer.toBinaryString(COUNT_MASK));
        System.out.println("RUNNING= "+RUNNING);
        System.out.println("RUNNING = "+Integer.toBinaryString(RUNNING));
        System.out.println("SHUTDOWN= "+SHUTDOWN);
        System.out.println("SHUTDOWN = "+Integer.toBinaryString(SHUTDOWN));
        System.out.println("STOP= "+STOP);
        System.out.println("STOP = "+Integer.toBinaryString(STOP));
        System.out.println("TIDYING= "+TIDYING);
        System.out.println("TIDYING = "+Integer.toBinaryString(TIDYING));
        System.out.println("TERMINATED= "+TERMINATED);
        System.out.println("TERMINATED = "+Integer.toBinaryString(TERMINATED));


    }
}
