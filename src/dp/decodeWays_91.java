package src.dp;

/**
 * @Author deng shuo
 * @Date 4/5/21 17:07
 * @Version 1.0
 */
public class decodeWays_91 {

    public int numDecodings(String s) {

        int len = s.length();

        int[] dp = new int[len+1];

        char[] s1 =s.toCharArray();
        if(s1[0] == '0') return 0;
        dp[0]=1;dp[1]=1;
        for (int i =1; i < len; i++) {
            if (s1[i] == '0')//1.s[i]为0的情况
                if (s1[i - 1] == '1' || s1[i - 1] == '2') //s[i - 1]等于1或2的情况
                    dp[i+1] = dp[i-1];//由于s[1]指第二个下标，对应为dp[2],所以dp的下标要比s大1，故为dp[i+1]
                else
                    return 0;
            else //2.s[i]不为0的情况
                if (s1[i - 1] == '1' || (s1[i - 1] == '2' && s1[i] <= '6'))//s[i-1]s[i]两位数要小于26的情况
                    dp[i+1] = dp[i]+dp[i-1];
                else//其他情况
                    dp[i+1] = dp[i];
        }
        return dp[len];

    }

    public int numDecodingsRecursion(String s){

        char[] charArray = s.toCharArray();

        int len = s.length();

        return recursion(charArray,len-1);

    }
    private int recursion(char[] chars,int index){

        if(index <=0){
            return 1;
        }
        int count = 0;
        char cur = chars[index];
        char prev = chars[index -1];

        if(cur > '0'){
            count = recursion(chars,index-1);
        }
        if(prev == '1' || (prev == '2' && cur <='6')){
            count += recursion(chars,index -2);
        }
        return count;
    }
}
