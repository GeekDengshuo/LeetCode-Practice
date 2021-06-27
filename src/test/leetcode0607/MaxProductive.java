package src.test.leetcode0607;

import java.util.Arrays;

/**
 * @Author deng shuo
 * @Date 6/27/21 10:38
 * @Version 1.0
 */
public class MaxProductive {
    public int maxProductDifference(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;

        return (nums[len-1] * nums[len-2]) - (nums[0] * nums[1]);

    }

    public static void main(String[] args) {
        int[] nums = {5,6,2,7,4};

        int[] nums2 = {4,2,5,9,7,4,8};

        MaxProductive mp = new MaxProductive();

        int res1 = mp.maxProductDifference(nums);
        int res2 = mp.maxProductDifference(nums2);

        System.out.println("res1 = "+res1 +"   res2 = "+res2);
    }
}
