package src.dp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author deng shuo
 * @Date 3/7/21 21:42
 * @Version 1.0
 */

/**
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s){
        int len = s.length();

        List<List<String>> res = new ArrayList<>();

        if(len == 0) return res;

        Deque<String> stack = new ArrayDeque<>();

        dfs(s.toCharArray(),0,len,stack,res);

        return res;

    }

    private void  dfs(char[] chars,int index,int len,
                Deque<String> path,List<List<String>> res){

        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < len; i++){
            if(!isPalindrome(chars,index,len)){
                continue;
            }
            path.addLast(new String(chars,index,i + 1 -index));
            dfs(chars,i+1,len,path,res);
            path.removeLast();

        }
    }

    private boolean isPalindrome(char[] chars,int left,int right){
        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    int[][] dp;
    List<List<String>> res = new ArrayList<List<String>>();
    List<String> cur = new ArrayList<>();
    int len;
    public List<List<String>> partitionImprove(String s) {
        len = s.length();
        dp = new int[len][len];

        dfs(s,0);
        return res;

    }
    private void dfs(String s,int index){
        if(index == len){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i= index;i<len;i++){
            if(isPalindromeImprove(s,index,i) == 1){
                cur.add(s.substring(i,index+1));
                dfs(s,index+1);
                cur.remove(cur.size()-1);
            }
        }

    }
    //搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    private int isPalindromeImprove(String s,int i,int j){
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(i>=j){
            dp[i][j] = 1;
        }else if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = isPalindromeImprove(s,i+1,j-1);
        }else{
            dp[i][j] = -1;
        }
        return dp[i][j];

    }
}
