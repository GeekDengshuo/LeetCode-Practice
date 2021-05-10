package src.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author deng shuo
 * @Date 5/10/21 21:41
 * @Version 1.0
 */


public class LeafSimilarTrees_872 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> res1 = new ArrayList<>();
    List<Integer> res2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        recusriveTree(root1,res1);
        recusriveTree(root2,res2);

        if(res1.size() != res2.size()) return false;

        for(int i= 0;i< res1.size();i++){
            if(res1.get(i) != res2.get(i)){
                return false;
            }
        }
        return true;

    }

    private void recusriveTree(TreeNode node,List<Integer> res){
        if(node == null) return;
        recusriveTree(node.left,res);
        if(node.left == null && node.right == null){
            res.add(node.val);
        }
        recusriveTree(node.right,res);


    }
}
