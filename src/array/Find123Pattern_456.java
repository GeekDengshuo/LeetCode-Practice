package src.array;

/**
 * @Author deng shuo
 * @Date 3/24/21 08:03
 * @Version 1.0
 */
public class Find123Pattern_456 {

    // bruce force
    public boolean find132Pattern(int[] nums){

        int len = nums.length;

        if(len < 3) return false;

        int minIndex = 0;
        int maxIndex = 0;
        int mediumIndex = 0;

        for(int i = 0;i<len;i++){
            minIndex = 0;
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
            if(nums[i] > nums[minIndex] && i > maxIndex){
                maxIndex = i;
            }
            if(nums[i] < nums[maxIndex] && i > maxIndex){
                mediumIndex = i;
            }

            if(mediumIndex > maxIndex && maxIndex > minIndex){
                return true;
            }
        }
        return false;

    }
}
