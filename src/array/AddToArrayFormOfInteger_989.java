package src.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author deng shuo
 * @Date 2021/1/22 22:32
 * @Version 1.0
 */
public class AddToArrayFormOfInteger_989 {

    /**
     * 方法太复杂
     * @param A
     * @param K
     * @return
     */

    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> result = new ArrayList<>();

        String str1 = Array2String(A);
        String str2 = String.valueOf(K);

        String reverse_str1 = ReverseString(str1);
        String reverse_str2 = ReverseString(str2);

        StringBuffer c_result = new StringBuffer();

        int flag = 0;

        int len1 = reverse_str1.length();
        int len2 = reverse_str2.length();
        int i = 0;
        int j = 0;
        while (i <len1 || j<len2){
            if(i< len1 && j<len2){
                int cur = reverse_str1.charAt(i) - '0' + reverse_str2.charAt(j) - '0' + flag;
                int num = cur%10;
                c_result.append(num);
                flag = cur/10 == 1? 1:0;
                i++;
                j++;
            }else if(i< len1){
                int cur = reverse_str1.charAt(i) - '0' + flag;
                int num = cur%10;
                c_result.append(num);
                flag = cur/10 == 1? 1:0;
                i++;
            }else if(j<len2){
                int cur = reverse_str2.charAt(j) - '0' + flag;
                int num = cur%10;
                c_result.append(num);
                flag = cur/10 == 1? 1:0;
                j++;
            }
        }
        if(flag == 1){
            c_result.append(1);
        }

        String reverse_c_result = ReverseString(c_result.toString());


        for(int k = 0;k<reverse_c_result.length();k++){
            result.add(reverse_c_result.charAt(i) - '0');
        }

        return result;

    }
    private String Array2String(int[] arrs){
        StringBuffer stringBuffer = new StringBuffer();
        for(int arr: arrs){
            stringBuffer.append(arr);
        }
        return stringBuffer.toString();

    }

    private String ReverseString(String str){
        StringBuffer stringBuffer = new StringBuffer();
        int len = str.length();
        for(int i = len -1 ;i>=0;i--){
            stringBuffer.append(str.charAt(i));
        }
        return stringBuffer.toString();
    }

    /**
     * 将A数组中的元素驾到K中(K依次保存数字位)
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        int[] A = {2,1,5};
        int K = 806;

        AddToArrayFormOfInteger_989 addToArray = new AddToArrayFormOfInteger_989();

        List<Integer> res = new ArrayList<>();

        res = addToArray.addToArrayForm(A,K);


    }
}
