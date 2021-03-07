package src.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author deng shuo
 * @Date 3/6/21 20:59
 * @Version 1.0
 */
public class NextGreaterElementII_503 {

    // 正确的思路是利用单调栈来实现

    public int[] nextGreaterElementWithStack(int[] nums){
        int len = nums.length;
        int[] greaterElement = new int[len];
        Arrays.fill(greaterElement,-1);

        Stack<Integer> stack = new Stack<Integer>();

        for(int i =0;i < (2*len -1); i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % len]){
                greaterElement[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return  greaterElement;

    }



    /**
     * 错误解答方法
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] nums){
        int len = nums.length;
        int[] greaterIndex = new int[len];
        Arrays.fill(greaterIndex,-1);

        for(int i = 0;i < len; i++){
            int index = i;
            while(index <len){
                if(nums[index] > nums[i]){
                    greaterIndex[i] = nums[index];

                }
                index++;
            }

            if(nums[i] == -1 && index == len) {
                index = 0;
                while (index < i) {
                    if (nums[index] > nums[i]) {
                        greaterIndex[i] = nums[index];

                    }
                    index++;
                }
            }
        }
        return greaterIndex;
    }


    public static void main(String[] args) {
        NextGreaterElementII_503 nextGreaterElement = new NextGreaterElementII_503();

        int[] testNum = {1,2,1};

        int[] res = nextGreaterElement.nextGreaterElement(testNum);

        System.out.println(res);
    }
}
