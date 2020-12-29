/**
 * @Author deng shuo
 * @Date 2020/12/29 22:56
 * @Version 1.0
 */
public class StringToInteger {
    // boundary value
    private int CalcNum(String str){
        int len = str.length();
        if(len == 0 ) return 0;
        int num = 0;
        boolean isNumber = true;
        for(int i= 0;i<len && isNumber;i++){
            int cur = (int)(str.charAt(i) - '0');
            if(cur >=0 && cur <=9){
                num = num *10 + cur;
            }
            else{
                isNumber = false;
            }
        }
        return num;

    }
    public int myAtoi(String s){
        int len = s.length();
        if(len <= 0 )
            return 0;
        int flag = 1;
        int index = 0;
        while(index < len && s.charAt(index)== ' '){
            index++;
        }
        if(index == len){
            return 0;
        }
        if(s.charAt(index) == '-'){
            flag = -1;
            s = s.substring(index);
        }
        return flag * CalcNum(s);
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        String s = "746";
        int res = stringToInteger.myAtoi(s);
        System.out.println(res);

    }
}
