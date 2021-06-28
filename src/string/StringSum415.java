package src.string;

/**
 * @Author deng shuo
 * @Date 6/28/21 21:36
 * @Version 1.0
 */
public class StringSum415 {

    public String addStrings(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();

        int i = len1 -1;
        int j = len2 -1;
        int flag = 0;
        StringBuffer result = new StringBuffer();

        while(i >= 0 || j>=0 || flag != 0){
            int x = i>=0 ? num1.charAt(i) - '0' : 0;
            int y = j>=0 ? num2.charAt(j) - '0' : 0;

            int cur = x + y + flag;
            result.append(cur%10);
            flag = cur/10;

            i--;
            j--;
        }
        result.reverse();
        return result.toString();

    }

}
