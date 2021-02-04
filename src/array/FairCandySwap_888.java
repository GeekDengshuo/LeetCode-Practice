package src.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author deng shuo
 * @Date 2021/2/1 21:12
 * @Version 1.0
 */
public class FairCandySwap_888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        // A and B is not Null
        int lenA = A.length;
        int lenB = B.length;

        int [] result = new int[2];

        int sumA = sumArr(A);
        int sumB = sumArr(B);


        for (int item : A) {
            for (int value : B) {
                if (sumA - item + value == sumB - value + item) {
                    result[0] = item;
                    result[1] = value;
                    break;
                }
            }
        }
        return result;

    }

    private int sumArr(int[] arr){
        int res = 0;
        for (int value : arr) {
            res += value;
        }
        return res;
    }

    public int[] fairCandySwap2(int[] A,int[] B){
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int diff = (sumA - sumB)/2;

        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int a : A){
            set.add(a);
        }
        for(int b : B){
            int res = b + diff;
            if(set.contains(res)){
                result[0] = res;
                result[1] = b;
            }
        }
        return result;
    }
}
