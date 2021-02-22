package src.slidingWindow;

import java.util.TreeMap;

/**
 * @Author deng shuo
 * @Date 2/21/21 21:14
 * @Version 1.0
 */
public class LongestContinuousSubarrayLimit_1438 {
    /**
     * bruce force
     * @param nums
     * @param limit
     * @return longestSubarray
     */
    public int longestSubarray(int[] nums, int limit){
        int len = nums.length;
        if(len == 1) return len;

        for(int i = 0;i< len;i++){
            for(int j = i;j <len ;j++){

            }
        }
        return len;
    }

    //

    public int longestSubarray2(int[] nums, int limit){
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;

    }
}
