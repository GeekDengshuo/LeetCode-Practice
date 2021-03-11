package src.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @Author deng shuo
 * @Date 3/11/21 20:19
 * @Version 1.0
 */
public class BasicCalculatorII_227 {
    public int calculate(String s){
        Deque<Integer> stack = new ArrayDeque<>();

        int len = s.length();
        int num = 0;
        char perSign = '+';

        int res = 0;

        for(int i = 0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + (s.charAt(i)-'0');
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len-1){
                switch (perSign){
                    case '+':
                        stack.push(num);
                        break;

                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    default:
                        stack.push(stack.pop()/num);
                }
                perSign = s.charAt(i);
                num = 0;
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
