package src.list;

/**
 * @Author deng shuo
 * @Date 2021/1/3 07:44
 * @Version 1.0
 */
public class PartitionList_86 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode (int val){this.val = val;}
    }

    // bulid a cycle list
    public static ListNode PartitionOfList(ListNode head,int num){
        // define cur node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode maxValueHead = new ListNode(0);
        ListNode cur = dummy;
        ListNode maxCur = maxValueHead;
        while(cur.next != null){
            if( cur.next.val >= num ){
                maxCur.next = cur.next;
                maxCur = cur.next;
                cur.next = cur.next.next;
                maxCur.next = null;         // import

            }else
            {
                cur = cur.next;
            }
        }
        cur.next = maxValueHead.next;
        return dummy.next;
    }
    public static ListNode PartitionOfList2(ListNode head,int num){
        ListNode minDummyNode = new ListNode(0);
        ListNode maxDummyNode = new ListNode(0);

        ListNode node1 = minDummyNode;
        ListNode node2 = maxDummyNode;
        while(head != null){
            if(head.val < num){
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;

            }else{
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = maxDummyNode.next;
        return minDummyNode.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node2_2 = new ListNode(2);

        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node2_2;

        int num = 3;
        ListNode cur = node1;
        while(cur != null){
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.println(" ");
        ListNode result = PartitionOfList(node1,num);
        ListNode result2 = PartitionOfList2(node1,num);
        // error cycle list
        System.out.println(" result 1:");
        while(result != null){
            System.out.print(result.val);
            System.out.print(" ");
            result = result.next;
        }
        System.out.println(" ");
        System.out.println(" result 2:");
        while(result2 != null){
            System.out.print(result2.val);
            System.out.print(" ");
            result2 = result2.next;
        }

    }
}
