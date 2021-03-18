package src.list;

/**
 * @Author deng shuo
 * @Date 3/18/21 21:03
 * @Version 1.0
 */
public class ReverseLinkedListII_92 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public ListNode reverseBetween2(ListNode head,int left,int right){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        for(int i = 1;i< left;i++){
            pre = pre.next;
        }

        ListNode cur = pre.next;

        ListNode next;

        for(int i= 0;i< right-left;i++){
            next = cur.next;
            cur.next = next.next;

            next.next = pre.next;
            pre.next = next;


        }
        return dummy.next;



    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1);

        dummy.next = head;


        ListNode pre = dummy;


        for(int i=0;i<left -1;i++){
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for(int i = 0;i< right-left+1;i++){
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseList(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;

        return dummy.next;


    }

    private void reverseList(ListNode head){
        ListNode prev = null;

        ListNode cur = head;
        ListNode next = null;
        while(cur !=null ){
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;


        }

    }
}
