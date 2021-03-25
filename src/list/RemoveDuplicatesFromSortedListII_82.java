package src.list;

/**
 * @Author deng shuo
 * @Date 3/25/21 08:29
 * @Version 1.0
 */

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int duplicate = cur.next.val;
                while(cur.next != null && cur.next.val == duplicate){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }


        }
        return  dummy.next;
    }
}
