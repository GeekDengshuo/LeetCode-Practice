package src.array;

/**
 * @Author deng shuo
 * @Date 2021/2/9 14:38
 * @Version 1.0
 */
public class LongestTurbulentSubarray_978 {

    /**
     * @param arr ,the input array
     * @return  maximum turbulent array length
     *
     * example  arr = [9,4,2,10,7,8,8,1,9]
     *          diff = [5,2,-8,3,-1,0,7,-8]
     *          diff = [1,1,-1,1,-1,0,1,-1]
     */
    public int maxTurbulenceSize(int[] arr){
        int len = arr.length;
        if(len == 1)
            return 1;
        int[] diff = new int[len -1];

        for(int i= 0;i< len -1 ;i++){
            diff[i] = arr[i+1] - arr[i];
        }
        // two pointer ?
        int maxLen = 0;
        int left = 0;
        int right = 0;
        while(left < len -1){
            int curLeft = left;
            while(diff[right] * diff[left] < 0){
                left = right;
                right++;
            }
            maxLen = Math.max(maxLen,right - curLeft +1);

            left++;
        }
        return maxLen +1;
    }

    public static void main(String[] args) {
        LongestTurbulentSubarray_978 lts = new LongestTurbulentSubarray_978();

        int[] arr = {9,4,2,10,7,8,8,1,9};
        int[] arr2 = {100};
        int[] arr3 = {4,8,12,16};
        int[] arr4= {9,9};

        int result1 = lts.maxTurbulenceSize(arr);
        int result2 = lts.maxTurbulenceSize(arr2);
        int result3 = lts.maxTurbulenceSize(arr3);
        int result4 = lts.maxTurbulenceSize(arr4);

        System.out.println("result1:"+result1);
        System.out.println("result2:"+ result2);
        System.out.println("result3:"+result3);
        System.out.println("result4:"+result4);
    }
}
