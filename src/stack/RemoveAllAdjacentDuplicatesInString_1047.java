package src.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author deng shuo
 * @Date 3/9/21 23:26
 * @Version 1.0
 */
public class RemoveAllAdjacentDuplicatesInString_1047 {

    public static String removeDuplicates(String S) {

        int len = S.length();

        char[] charArray = S.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0;i < len; i++){
            if(stack.isEmpty() || charArray[i] != stack.peek()){
                stack.push(charArray[i]);
            }else{
                stack.pop();
            }

        }

        return stack.toString();



    }

    public static void main(String[] args) {
        String str = "abbaca";
        String res = removeDuplicates(str);

        System.out.println(res);


    }
}
