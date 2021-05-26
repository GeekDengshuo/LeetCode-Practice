package src.dp;

/**
 * @Author deng shuo
 * @Date 5/25/21 20:04
 * @Version 1.0
 */
public class TrappingRainWater_42 {

    /**
     * @param heights 每个点的高度
     * @return
     */
    public int MaxStoreRainWater(int[] heights){

        if(heights.length <= 1) return 0;

        int len = heights.length;

        int[] leftMaxStore = new int[len];
        int[] rightMaxStore = new int[len];

        leftMaxStore[0] = heights[0];

        for(int i = 1;i<len;i++){
            leftMaxStore[i] = Math.max(leftMaxStore[i-1],heights[i]);
        }

        rightMaxStore[len-1] = heights[len -1];

        for(int i= len-2;i>=0;i--){
            rightMaxStore[i] = Math.max(rightMaxStore[i+1],heights[i]);
        }

        int res = 0;

        for(int i= 0;i<len;i++){
            res += Math.min(leftMaxStore[i],rightMaxStore[i]) - heights[i];
        }

        return res;
    }
}
