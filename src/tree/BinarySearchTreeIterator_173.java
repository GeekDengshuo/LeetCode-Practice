package src.tree;

import java.util.*;

/**
 * @Author deng shuo
 * @Date 3/28/21 09:03
 * @Version 1.0
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){this.val = x;}
}
public class BinarySearchTreeIterator_173 {

    public void BSTInorder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> stack = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        /*
        while(cur != null){
            stack.offer(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()){
            if(stack.poll().right != null){
                TreeNode right = stack.poll().right;
                while(right!= null){
                    stack.offer(right);
                    right = right.left;
                }
            }else{
                list.add(stack.poll().val);
            }
        }
        */

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.offer(cur);
                cur = cur.left;
            }
            cur = stack.poll();
            list.add(cur.val);
            cur = cur.right;
        }
    }

    class BSTIterator {

        List<Integer> list = new ArrayList<Integer>();


        public BSTIterator(TreeNode root) {

            Deque<TreeNode> stack = new LinkedList<>();

            while(root != null || !stack.isEmpty()){

                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }

        }

        /** @return the next smallest number */
        public int next() {
            return list.iterator().next();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return list.iterator().hasNext();
        }
    }
}
