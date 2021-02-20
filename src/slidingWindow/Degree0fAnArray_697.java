package src.slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 2/20/21 21:06
 * @Version 1.0
 */
public class Degree0fAnArray_697 {

    public int findShortestSubArray(int[] nums){

        Map<Integer, List<Integer>> numIndex = new HashMap<>();

        // index
        for(int index = 0 ;index < nums.length;index++){
            if(!numIndex.containsKey(nums[index])){
                List<Integer> listIndex = new LinkedList<>();
                listIndex.add(index);
                numIndex.put(nums[index],listIndex);
            }else{
                numIndex.get(nums[index]).add(index);
            }
        }
        // loop the hashMap

        int maxLen = 0;
        int shortestLen = 1;
        for(int key: numIndex.keySet()){
            int len = numIndex.get(key).size();
            if(len >maxLen){
                maxLen = len;
                shortestLen = numIndex.get(key).get(len-1) - numIndex.get(key).get(0) + 1;
            }
            if(len == maxLen){
                shortestLen = Math.min(shortestLen,numIndex.get(key).get(len-1) - numIndex.get(key).get(0) + 1);
            }

        }

        return shortestLen;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,1};
        Degree0fAnArray_697 doa = new Degree0fAnArray_697();

        int len = doa.findShortestSubArray(nums);

        System.out.println(len);
    }
}
