package src.slidingWindow;

/**
 * @Author deng shuo
 * @Date 2/19/21 21:14
 * @Version 1.0
 */

//maintenance sliding windows
public class MaxConsecutiveOnesIII_1004 {

    public int longestOnes(int[] A ,int K){
        int count = 0;

        int maxLen = 0;

        int len = A.length;

        int left = 0;
        int right = 0;

        while(right < len){
            if(A[right] == 0){
                count++;

            }
            while(count > K){
                maxLen = Math.max(maxLen,right-left);

                if(A[left] == 0){
                    count --;
                }
                left++;
            }
            right++;
        }
        return maxLen;
    }

    public int longestOnes2(int[] A, int K) {
        int N = A.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            if (A[right] == 0)
                zeros ++;
            while (zeros > K) {
                if (A[left++] == 0)
                    zeros --;
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }

}
