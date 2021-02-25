package src.slidingWindow;

/**
 * @Author deng shuo
 * @Date 2/23/21 21:26
 * @Version 1.0
 */

/**
 * 1.找到长度为X的最大连续子数组
 * 2.记录下标
 */
public class GrumpyBookStoreOwner_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int maxResult = 0;
        int startIndex = 0;
        for(int i = 0;i <= customers.length - X ;i++){
            int curResult = 0;
            for(int j = 0;j < X;j++){
                curResult += customers[i+j];
            }
            if(curResult > maxResult){
                maxResult = curResult;
                startIndex = i;
            }

        }
        for(int i = 0;i < customers.length;i++){
            if((i>= startIndex && i < startIndex+X) || grumpy[i] == 1){
                continue;
            }
            maxResult+= customers[i];

        }
        return maxResult;


    }

    public static void main(String[] args) {
        GrumpyBookStoreOwner_1052 GBSO = new GrumpyBookStoreOwner_1052();
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int X = 3;

        int res = GBSO.maxSatisfied(customers,grumpy,X);

        System.out.println(res);

    }
}
