package src.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author deng shuo
 * @Date 2021/1/10 22:30
 * @Version 1.0
 */
public class SummaryRanges_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int len = nums.length;

        if (len == 0) return res;
        if (len == 1) {
            String cur = String.valueOf(nums[0]);
            res.add(cur);
            return res;
        }

        int left = 0;
        int right = left + 1;
        //String cur = new String(" ")
        while (left < right && right < len) {

            if (nums[right] - nums[right - 1] == 1) {
                right++;

                // until range
                if (right == len) {
                    String cur = String.valueOf(nums[left]) + "->" + String.valueOf(nums[right - 1]);
                    res.add(cur);
                }
            } else {
                //
                if (right - left == 1) {
                    String cur = String.valueOf(nums[left]);
                    res.add(cur);

                } else {
                    String cur = String.valueOf(nums[left]) + "->" + String.valueOf(nums[right - 1]);
                    res.add(cur);
                }

                left = right;

                if (left == len - 1) {
                    String cur = String.valueOf(nums[left]);
                    res.add(cur);
                    break;
                }
                right = left + 1;

            }

        }

        return res;
    }
    //  我的方法也是双指针，但是循环方法不太好
    //  循环体中左指针递增即可，无需右指针递(记录位置即可)
    public List<String> summaryRangesImprove(int[] nums){
        List<String> res = new ArrayList<String>();
        int len = nums.length;
        int left = 0;
        while(left < len){
            int start = left;
            left++;
            while(left < len && nums[left] == nums[left -1] + 1){
                left++;
            }
            int end = left - 1;

            StringBuffer stringBuffer = new StringBuffer(Integer.toString(nums[start]));

            if(start < end){
                stringBuffer.append("->");
                stringBuffer.append(Integer.toString(nums[end]));
            }
            res.add(stringBuffer.toString());

        }
        return res;
    }

    public static void main(String[] args) {

    }
}
