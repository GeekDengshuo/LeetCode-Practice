package src.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 2021/1/26 22:04
 * @Version 1.0
 */
public class NumberOfEquivalentDominoPairs_1128 {
    // 错误的解题思路
    public int numEquivDominoPairs(int[][] dominoes) {
        int nums = 0;
        Map<Integer,Integer> dict = new HashMap<>();

        for(int[] cur : dominoes){
            if(dict.containsKey(cur[0]) && dict.containsKey(cur[1])){
                if(dict.get(cur[0]) == 1 && dict.get(cur[1]) ==1){
                    nums++;
                    dict.put(cur[0],0);
                    dict.put(cur[1],0);
                }

            }else{
                dict.put(cur[0],1);
                dict.put(cur[1],1);

            }
        }
        return nums;
    }
    public int numEquivDominoPairs2(int[][] dominoes) {

        int[] dict = new int[100];

        int nums = 0;

        for(int[] cur: dominoes){
            int res = cur[0] < cur[1] ? cur[0] *10 + cur[1] : cur[1]*10 +cur[0];
            nums += dict[res];
            dict[res]++;
        }
        return nums;

    }

}
