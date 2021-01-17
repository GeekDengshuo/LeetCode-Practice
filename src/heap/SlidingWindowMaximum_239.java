package src.heap;

import java.util.LinkedList;

/**
 * @Author deng shuo
 * @Date 2021/1/17 09:47
 * @Version 1.0
 */
public class SlidingWindowMaximum_239 {

    /**
     * bruce force
     * @param nums   数组
     * @param k      滑动窗口的大小
     * @return
     */
    public int[] maxSlidingWindowBruceForce(int[] nums,int k){
         int len = nums.length;
         int new_len = len >= k ? len - k +1 : 1;
         int[] result = new int[new_len];

         int maxValue = Integer.MIN_VALUE;

         for(int num:nums){
             if(num > maxValue){
                 maxValue = num;
             }
         }

         if(len < k){
             result[0] = maxValue;
         }
         // 边界循环问题
         for(int i = 0 ;i< len - k;i++){
             int curMax = nums[i];
             for(int j= i;j< i+k; j++){
                 if(nums[j] > curMax){
                     curMax = nums[j];
                 }
             }
             result[i] = curMax;
         }
         return result;
    }

    /**
     * 使用双向队列存储下标实现
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowWithQueue(int[] nums,int k){
        // 错误输入 k > nums.length
        // nums
        if(nums == null || nums.length < 2) return nums;

        int[] result = new int[nums.length-k+1];
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            // 队列不为空，且最后元素小于当前值
            while(!deque.isEmpty() || nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);

            // 判断当前队列中队首的值是否有效
            if(deque.peek() <= i-k){
                deque.poll();
            }
            if(i+1 >= k){
                result[i+1-k] = nums[deque.peek()];
            }
        }
        return result;
    }
}
