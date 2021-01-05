package src.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author deng shuo
 * @Date 2021/1/5 21:41
 * @Version 1.0
 */
public class PositionOfLargeGroups_830 {


    public static List<List<Integer>> LargeGroupsPosition(String s){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(s.length() < 3) return res;

        Character duplicate = s.charAt(0);
        boolean flag = false;
        int left = 0;
        int right = 1;
        int start = 0;
        int end = 0;
        while(left < right && right <s.length()){
            if(s.charAt(left) == s.charAt(right)){
                start = left;
                end = right;
                if(right == s.length() -1 && end -start >=2){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(start);
                    cur.add(end);
                    res.add(cur);
                    start = 0;
                    end = 0;
                }
                right++;
            }else{
                // 最后的结果还在保存
                if(end - start >=2){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(start);
                    cur.add(end);
                    res.add(cur);
                    start = 0;
                    end = 0;
                }
                left = right;
                right ++;
            }
        }
        return  res;

    }

    public static List<List<Integer>> LargeGroupsPosition_improve(String s){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int num = 1;
        int n = s.length();

        for(int i = 0;i < n;i++){
            if(i == n-1 || s.charAt(i) != s.charAt(i+1)){
                if(num >=3 ){
                    res.add(Arrays.asList(i-num +1,i));
                }
                // restart
                num = 1;

            }else{
                num++;
            }
        }
        return res;
    }




    public static void main(String[] args) {
        String s = "abbxxxxzzy";
        String s1 = "abcdddeeeeaabbbcd";
        String s3 = "aba";
        String s4 = "aaa";

        long start_time = System.nanoTime();
        List<List<Integer>> result = LargeGroupsPosition(s);
        List<List<Integer>> result1 = LargeGroupsPosition(s1);
        List<List<Integer>> result3 = LargeGroupsPosition(s3);
        List<List<Integer>> result4 = LargeGroupsPosition(s4);
        long end_time = System.nanoTime();

        System.out.println("LargeGroupsPosition time = "+(end_time- start_time)+"ns");

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result3);
        System.out.println(result4);

        long start_time_improve = System.nanoTime();
        List<List<Integer>> result_improve = LargeGroupsPosition_improve(s);
        List<List<Integer>> result_improve1 = LargeGroupsPosition_improve(s1);
        List<List<Integer>> result_improve3= LargeGroupsPosition_improve(s3);
        List<List<Integer>> result_improve4 = LargeGroupsPosition_improve(s4);
        long end_time_improve = System.nanoTime();
        System.out.println("LargeGroupsPosition_improve time = "+(end_time_improve- start_time_improve)+"ns");

        System.out.println(result_improve);
        System.out.println(result_improve1);
        System.out.println(result_improve3);
        System.out.println(result_improve4);

        // 1ms = 1000000ns
        // 1s = 1000ms
        // 1s = 1e9 ns






    }
}
