package src.array;

/**
 * @Author deng shuo
 * @Date 4/7/21 07:39
 * @Version 1.0
 */
public class SearchInRotatedSortedArrayII_81 {
    // 2,5,6,0,0,1,2 target = 5
    // 0 1 2 3 4 5 6
    public boolean search(int[] nums,int target){

        int len = nums.length;

        if(len == 1){
            return nums[0] == target;
        }

        int left = 0;
        int right = len -1;

        while(left < right){
            int mid = (left +right)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < nums[right]){
                if(nums[right] >= target &&  nums[mid] < target){
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }else{
                if(nums[left] <= target  && nums[mid] > target){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }
        }
        return false;

    }
}
