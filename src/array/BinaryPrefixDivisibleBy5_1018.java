package src.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author deng shuo
 * @Date 2021/1/14 22:11
 * @Version 1.0
 */
public class BinaryPrefixDivisibleBy5_1018 {

    public static List<Boolean> prefixesDivBy5(int[] A) {
        int len = A.length;
        List<Boolean> result = new ArrayList<Boolean>();
        int num = 0;
        for(int i = 0; i < len; i++){
            num <<= 1;
            num += A[i];
            num %= 5;
            result.add(num % 5 == 0);

        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,0,1,0};

        List<Boolean> res = new ArrayList<>();

        res = prefixesDivBy5(arr);

        for(boolean b : res){
            System.out.println(b);
        }
    }
}
