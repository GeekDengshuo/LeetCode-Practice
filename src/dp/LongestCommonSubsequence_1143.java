package src.dp;

/**
 * @Author deng shuo
 * @Date 4/3/21 08:59
 * @Version 1.0
 */
public class LongestCommonSubsequence_1143 {

    public static int longCommonSubsequence(String text1,String text2){
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1+1][len2+1];

        // 无需初始化  java默认是0
        for(int i = 0;i <= len1 ;i++){
            dp[i][0] = 0;
        }
        for(int j = 0;j <= len2 ;j++){
            dp[0][j] = 0;
        }
        for(int i= 1;i<=len1;i++){
            for(int j= 1;j<=len2;j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int result = longCommonSubsequence(text1,text2);

        System.out.println(result);

    }


}
