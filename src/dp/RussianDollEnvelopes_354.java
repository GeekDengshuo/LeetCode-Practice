package src.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author deng shuo
 * @Date 3/4/21 22:25
 * @Version 1.0
 */
public class RussianDollEnvelopes_354 {
    public int numOfEnvelopesWithRussianDoll(int[][] envelops){

        // index 0 的升序  index1的降序
        Arrays.sort(envelops, (o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o2[1] - o1[1];
            }
        });

        int[] dp = new int[envelops.length];
        Arrays.fill(dp,1);
        int res = dp[0];
        for(int i = 1;i< envelops.length;++i){
            for(int j = 0;j < i;++j){
                if(envelops[j][1] <  envelops[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;



    }

    public static void main(String[] args) {
        int[][] envelops = {{4,5},{4,6},{6,7},{2,3},{1,1}};

        RussianDollEnvelopes_354 rsde = new RussianDollEnvelopes_354();
        int res = rsde.numOfEnvelopesWithRussianDoll(envelops);

        System.out.println(res);

        int res2 = rsde.maxEnvelopes(envelops);

        System.out.println(res2);
    }
}
