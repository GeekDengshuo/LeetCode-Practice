package src.array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author deng shuo
 * @Date 4/11/21 12:22
 * @Version 1.0
 */
public class UglyNumberII_264 {

    public int nthUglyNumber(int n) {

        if(n == 0)  return -1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;

        for(int i = 1;i<n;i++){

            uglyNumber[i] = Math.min(uglyNumber[index2] *2,
                                    Math.min(uglyNumber[index3] * 3,
                                            uglyNumber[index5] * 5));

            if(uglyNumber[i] == uglyNumber[index2] * 2){
                index2 ++;
            }
            if(uglyNumber[i] == uglyNumber[index3] * 3){
                index3 ++;
            }
            if(uglyNumber[i] == uglyNumber[index5] * 5){
                index5 ++;
            }

        }
        return uglyNumber[n-1];

    }

    public int nthUglyNumber2(int n){
        if(n <= 0)  return -1;

        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int[] factors = {2,3,5};

        set.add(1L);
        pq.offer(1L);

        int ugly = 0;
        for(int i = 0;i<n;i++){

            long cur =  pq.poll();

            ugly = (int)cur;
            for(int factor:factors){
                if(set.add(factor * cur)){
                    pq.offer(factor * cur);
                }
            }

        }
        return ugly;

    }
}
