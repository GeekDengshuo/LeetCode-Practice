package src.array;

/**
 * @Author deng shuo
 * @Date 2021/2/4 21:20
 * @Version 1.0
 */
public class MaximumAverageSubarrayI_643 {
    public double findMaxAverage(int[] nums, int k) {

        // error input
        if(nums.length < k) return 0.0;

        double maxAverage = -10000;

        System.out.println(maxAverage);

        for(int i = 0; i <= nums.length - k;i++){
            double curAverage = average(nums,i,k);

            System.out.println("curAverage:");
            System.out.println(curAverage);
            maxAverage = Math.max(maxAverage,curAverage);

            System.out.println("maxAverage:");
            System.out.println(maxAverage);
        }
        System.out.println(maxAverage);
        return maxAverage;

    }
    private double average(int[] nums,int index,int len){
        int sum = 0;
        for(int i= index;i<index+len;i++){
            sum += nums[i];
        }
        System.out.println(sum);
        return (double)sum/len;
    }


    public static void main(String[] args) {
        MaximumAverageSubarrayI_643 maxAverageSubarray = new MaximumAverageSubarrayI_643();

        double cur = -1.0;
        double minValue = Double.MIN_VALUE;
        double maxValue = Double.MAX_VALUE;
        double maxExponent = Double.MAX_EXPONENT;
        double x = Double.MIN_NORMAL;

        double cur_max = Math.max(cur,minValue);

        System.out.println(cur_max);


    }
}
