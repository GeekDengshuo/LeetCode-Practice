package src.array;

/**
 * @Author deng shuo
 * @Date 4/8/21 07:47
 * @Version 1.0
 */
// [4,5,6,7,0,1,2]
public class FindMinimumInRotatedSortedArray_153 {

    public int findMin(int[] nums) {
        int len = nums.length;
        if(len == 1) return  nums[0];

        int left = 0;
        int right = len -1;

        while(left <right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];

    }

    public int findNum2(int[] nums){
        int len = nums.length;
        if(len == 1) return  nums[0];

        int left = 0;
        int right = len -1;

        while(left <= right){
            int mid = (left + right)/2;
            if(nums[left] > nums[right]){
                if(nums[mid] > nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                return nums[left];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        FindMinimumInRotatedSortedArray_153 fmr = new FindMinimumInRotatedSortedArray_153();

        int res = fmr.findNum2(nums);
        int res2 = fmr.findMin(nums);
    }
}
