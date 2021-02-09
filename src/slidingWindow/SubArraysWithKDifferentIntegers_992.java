package src.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author deng shuo
 * @Date 2021/2/9 09:05
 * @Version 1.0
 */
public class SubArraysWithKDifferentIntegers_992 {

    public int subArraysWithKDifferent(int[] A,int K){
        int len = A.length;
        HashMap<Integer,Integer> dict = new HashMap<>();
        for(int i = 0;i < K;i++){
            if(dict.containsKey(A[i])){
                dict.put(A[i],dict.get(A[i])+1);
            }else{
                dict.put(A[i],1);
            }
        }
        int left = 0;
        int right = K;
        int count = 0;
        if(dict.keySet().size() == K) count++;

        while(right < len && left < right){
            if(dict.containsKey(A[right])){
                dict.put(A[right],dict.get(A[right])+1);
            }else{
                dict.put(A[right],1);
            }

            if(dict.keySet().size() > K){
                dict.remove(A[left]);
                left++;

            }else{
                count++;
                right++;
            }
        }
        return count;
    }

    public int subarraysWithKDistinc2t(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    /**
     * @param A
     * @param K
     * @return 最多包含 K 个不同整数的子区间的个数
     */
    private int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0;
        int right = 0;
        // [left, right) 里不同整数的个数
        int count = 0;
        int res = 0;
        // [left, right) 包含不同整数的个数小于等于 K
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            // [left, right) 区间的长度就是对结果的贡献
            res += right - left;
        }
        return res;
    }


}
