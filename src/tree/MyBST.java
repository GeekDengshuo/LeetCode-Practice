package src.tree;

/**
 * @Author deng shuo
 * @Date 4/18/21 09:57
 * @Version 1.0
 */

public class MyBST <Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;

        private Node left,right;

        private Node parent;
        private int N;

        public Node(Key key, Value val,int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    // 对外接口
    public int size(){
        return size(root);
    }

    public Value get(Key key){
        return get(root,key);
    }

    public void put(Key key,Value val){
        root =  put(root,key,val);
    }

    public Node minValue(){
        return minValue(root);
    }
    public Node maxValue(){
        return maxValue(root);
    }



    public Node successor(Node x){
        if(x.right != null){
            return minValue(x.right);
        }
        Node y = x.parent;
        while(y != null && x == y.right){
            x = y;
            y = y.parent;
        }
        return y;
    }
    public Node predecessor(Node x){
        if(x.left != null) return maxValue(x.left);

        Node y = x.parent;
        while(y != null && x == y.left){
            x = y;
            y = y.parent;
        }
        return y;
    }


    // 内部实现
    private int size(Node root){
        if(root == null) return 0;
        return root.N;
    }
    private Value get(Node x,Key key){
        if(x == null) return null;

        int cmp = key.compareTo(x.key);

        if(cmp > 0) return get(x.right,key);
        else if(cmp < 0) return get(x.left,key);
        else return x.val;
    }
    private Node put(Node x,Key key,Value val){
        if(x == null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if (cmp >0) x.right = put(x.right,key,val);
        else if(cmp <0) x.left = put(x.left,key,val);
        else x.val = val;

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node minValue(Node x){
        while(x.left != null){
            x = x.left;
        }
        return x;
    }

    private Node maxValue(Node x){
        while(x.right != null){
            x = x.right;
        }
        return x;
    }


    // remove Node
    public void deleteMin(){
        root = deleteMin(root);
    }
    public void deleteMax(){
        root = deleteMax(root);
    }
    public void delete(Key key){
        root = delete(root,key);
    }

    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }
    private Node deleteMax(Node x){
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }
    /**
     * 没有考虑父结点情况
     * */
    private Node delete(Node x,Key key){

        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0) x.right = delete(x.right,key);
        else if (cmp < 0) x.left = delete(x.left,key);
        // find t
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;

            Node t = x;

            x = successor(x.right);

            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) +1;

        return x;
    }




}
