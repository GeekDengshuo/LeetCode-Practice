package src.array;

/**
 * @Author deng shuo
 * @Date 2021/2/5 22:03
 * @Version 1.0
 */
public class GetEqualSubstringsWithinBudget_1208 {

    private static int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();

        int curCost = 0;
        int res = 0;
        for(int i = 0;i < len;i++){
            int abs= Math.abs(t.charAt(i) - s.charAt(i));
            curCost += abs;

            if(curCost <= maxCost){
                res++;
            }else{
                curCost -= abs;
            }
        }
        return  res;
    }

    public static int equalSubstring2(String s, String t, int maxCost){
        int len = s.length();

        int[] diff = new int[len];
        for(int i = 0;i< len;i++){
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0;
        int right = 0;
        int curCost = 0;
        int maxLen = 0;

        while(right < len){
            curCost += diff[right];
            while(curCost > maxCost){
                curCost -= diff[left];
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;

        }
        return maxLen;


    }



    public static void main(String[] args) {
        String s = "abcd";
        String t = "czef";
        int cost = 4;

        int res = equalSubstring(s,t,cost);

        System.out.println(res);
    }
}
