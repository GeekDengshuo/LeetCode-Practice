package src.slidingWindow;

import java.util.Arrays;

/**
 * @Author deng shuo
 * @Date 2021/2/6 17:45
 * @Version 1.0
 */
public class MaximumPointsCanObtainFromCards_1423 {

    public static int maxScore(int[] cardPoints, int k) {

        int len = cardPoints.length;
        int windowSize = len - k;
        int allSum = Arrays.stream(cardPoints).sum();

        int curSum = 0;
        int index = 0;

        for(index = 0;index < windowSize ;index++){
            curSum += cardPoints[index];
        }
        int minSum = curSum;
        int left = 0 ;
        int right = index;
        while(left < right && right < len){
            curSum += cardPoints[right] - cardPoints[left];
            minSum = Math.min(minSum,curSum);
            left++;
            right++;
        }

        return allSum - minSum;

    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        int result = maxScore(cardPoints,k);

        System.out.println("result = "+ result);
        System.out.println(result);
    }


}
