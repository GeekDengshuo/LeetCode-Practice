package src.array;

import java.util.Arrays;

/**
 * @Author deng shuo
 * @Date 2021/1/28 20:39
 * @Version 1.0
 */
public class FindPivotIndex_724 {

    /**
     * bruce force
     */
    public int pivotIndex(int[] nums){

        if(nums.length <= 0) return -1;

        int pivot = -1;

        for(int mid = 0; mid < nums.length ; mid++){
            int left = 0;
            int right = 0;

            int i = 0;
            int j = mid+1;

            while(i < mid){
                left += nums[i];
                i++;
            }
            while(j < nums.length){
                right += nums[j];
                j++;
            }

            if(left == right){
                pivot = mid;
                break;
            }
        }
        return pivot;

    }

    /**
     * binary search
     */
    public int pivotIndex2(int[] nums){
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;

    }

    public static void main(String[] args) {
        FindPivotIndex_724 findPivot = new FindPivotIndex_724();

        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {0,0,0,0,1};

        int result = findPivot.pivotIndex(nums2);

        System.out.println(result);
    }
}
