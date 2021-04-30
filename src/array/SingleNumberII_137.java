package src.array;

/**
 * @Author deng shuo
 * @Date 4/30/21 16:25
 * @Version 1.0
 */
public class SingleNumberII_137 {
    public int singleNumber(int[] nums) {

        int ans = 0;

        for(int i= 0;i < 32;i++){
            int total = 0;
            for(int num:nums){
                // 当前位置累加
                total += ((num>>i)&1);
            }
            // 3N or 3N+1
            if(total %3 != 0){
                ans |= 1<<i;
            }
        }
        return ans;

    }
}
