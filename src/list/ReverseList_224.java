package src.list;

import java.util.List;

/**
 * @Author deng shuo
 * @Date 3/18/21 20:53
 * @Version 1.0
 */

public class ReverseList_224 {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int x){val = x;}
    }


    public ListNode reverseList(ListNode head) {

        ListNode pre = null;

        ListNode cur = head;
        ListNode next = null;
        while(cur !=null){
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;

        }

        return pre;

    }

}
