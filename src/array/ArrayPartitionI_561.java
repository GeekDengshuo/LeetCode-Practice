package src.array;

import java.util.Arrays;

/**
 * @Author deng shuo
 * @Date 2/16/21 22:00
 * @Version 1.0
 */
public class ArrayPartitionI_561 {
    public int arrayPairSum(int[] nums){
        // sort the array
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i< nums.length;i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
