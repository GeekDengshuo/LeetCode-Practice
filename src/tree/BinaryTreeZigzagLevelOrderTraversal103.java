package src.tree;

import java.util.*;

/**
 * @Author deng shuo
 * @Date 6/29/21 22:18
 * @Version 1.0
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        int flag = 1;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> cur  = new LinkedList<>();
            for(int i = 0;i<len;i++){

                TreeNode curNode = queue.poll();
                if(curNode != null){
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                    if(flag == 1){
                        cur.add(curNode.val);
                    }else{
                        cur.add(0,curNode.val);
                    }
                }

            }
            flag = flag ^ 1;
            if(cur.size()!= 0){
                result.add(cur);
            }

        }
        return result;

    }
}
