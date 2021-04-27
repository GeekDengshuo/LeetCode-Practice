package src.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author deng shuo
 * @Date 4/25/21 22:52
 * @Version 1.0
 */
public class IncreasingOrderSearchTree_897 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){};
        public TreeNode(int val){
            this.val = val;
        }
    }
    private List<Integer> treeNodeList = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return root;
        Inorder(root);

        return buildTree();
    }

    private void Inorder(TreeNode root){
        if(root == null) return;

        Inorder(root.left);

        treeNodeList.add(root.val);

        Inorder(root.right);
    }

    private TreeNode buildTree(){
        TreeNode dummy = new TreeNode(-1);
        TreeNode root = dummy;

        for(int node: treeNodeList){
            TreeNode cur = new TreeNode(node);
            root.right = cur;
            root = cur;
        }
        return dummy.right;

    }

    private TreeNode resNode;
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        resNode = dummy;
        InorderTravesal(root);
        return dummy.right;

    }

    private void  InorderTravesal(TreeNode root){
        if(root == null) return;
        InorderTravesal(root.left);
        resNode.right = root;
        root.left = null;
        resNode = root;
        InorderTravesal(root.right);
    }
}
