package src.array;

/**
 * @Author deng shuo
 * @Date 4/7/21 07:40
 * @Version 1.0
 */
public class SearchInRotatedSortedArray_33 {

    // 错误解法
    public int search(int[] nums, int target){

        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;


        /*
        int len = nums.length;
        int left = 0;
        int right = len -1;

        while(left < right){
            int mid = (left +right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > nums[right]){
                if(nums[right] > target){
                    left = mid+1;
                }else{
                    right = mid -1;
                }

            }else{
                if(nums[right] > target){
                    left = mid+1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;


        */
    }

}
