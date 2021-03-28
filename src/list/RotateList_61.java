package src.list;

/**
 * @Author deng shuo
 * @Date 3/27/21 10:14
 * @Version 1.0
 */

/**
 * 首尾回环
 */
public class RotateList_61 {


    public ListNode rotateRight(ListNode head ,int k){
        if(head == null || head.next == null) return head;

        // listNode length
        int len = 1;
        ListNode  cur = head;
        while(cur.next != null){
            cur = cur.next;
            len ++;
        }
        // update rotate
        k = k % len;

        int left = len - k;

        if(left == len){
            return head;
        }
        // connect tail and head
        cur.next = head;

        while(left-- >0){
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;

        return newHead;



    }
}
