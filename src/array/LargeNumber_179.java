package src.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author deng shuo
 * @Date 4/12/21 06:59
 * @Version 1.0
 */
public class LargeNumber_179 {

    // 1.对数组中的元素重排序
    public String largestNumber(int[] nums) {
        if(nums.length <= 0) return "";

        Integer[] numArr = new Integer[nums.length];
        for(int i = 0;i< nums.length;i++){
            numArr[i] = nums[i];
        }

        Arrays.sort(numArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int prod1 =10;
                int prod2 = 10;
                while(prod1 <= (int)o1){
                    prod1 *=10;
                }
                while(prod2 <= (int)o2){
                    prod2 *=10;
                }
                return (int)(prod1 * o2 + o1 - prod2 *o1 -o2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        if(numArr[0] == 0) return "0";
        for(int num: numArr){
            stringBuilder.append(num);
        }

        return stringBuilder.toString();
    }




}
