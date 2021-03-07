package src.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author deng shuo
 * @Date 3/8/21 22:19
 * @Version 1.0
 */
public class PalindromePartitioningII_132 {

    int minLen = 0;

    public int minCut(String s){

        int len = s.length();
        char[] charArray = s.toCharArray();

        minLen = len;

        Deque<String> stack = new ArrayDeque<>();


        dfs(charArray,0,len,stack);

        return minLen -1;

    }

    private void dfs(char[] charArrays,int index,int len,Deque<String> stack){

        if(index == len){
            minLen = Math.min(minLen,stack.size());
        }

        for(int i = index; i < len;i++){
            if(!palindrome(charArrays,index,i)){
                continue;
            }
            stack.addLast(new String(charArrays,i,i+1-index));
            dfs(charArrays,i+1,len,stack);
            stack.removeLast();
        }
    }

    private boolean palindrome(char[] chars,int left,int right){

        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int minCutImprove(String s){
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];

    }


    public static void main(String[] args) {
        PalindromePartitioningII_132 pdp = new PalindromePartitioningII_132();

        String str = "aab";

        int res = pdp.minCut(str);

        System.out.println(res);
    }
}
