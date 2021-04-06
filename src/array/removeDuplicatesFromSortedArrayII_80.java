package src.array;

/**
 * @Author deng shuo
 * @Date 4/6/21 07:22
 * @Version 1.0
 */
public class removeDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return 1;

        int left = 0;
        int right = left+1;

        while(left < right && right <len){
            if(nums[left] != nums[right]){
                left = right;
                //right++;
            }else if(right - left > 1){
                for(int i = right;i<len-1;i++){
                    nums[i] = nums[i+1];
                }
            }
            right++;
        }
        return right;

    }
}
