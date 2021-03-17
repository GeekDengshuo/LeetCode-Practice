package src.dp;

/**
 * @Author deng shuo
 * @Date 3/17/21 20:46
 * @Version 1.0
 */
public class DistinctSubsequences_115 {

    public int numDistinct(String s,String t){
        int sLen = s.length();
        int tLen = t.length();

        int[][] dp = new int[sLen + 1][tLen + 1];

        dp[0][0] = 1;

        for(int i = 1;i<= sLen;i++){
            dp[i][0] = 1;

            for(int j = 1;j<= tLen;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        return  dp[sLen][tLen];
    }
}
