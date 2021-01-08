package src.graph;

import java.awt.event.WindowEvent;

/**
 * @Author deng shuo
 * @Date 2021/1/7 22:20
 * @Version 1.0
 */

// union find
public class NumberOfProvinces_547 {

    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;

        UnionFind unionFind = new UnionFind(row);

        for (int i = 0; i < row ; i++) {
            for(int j = 0;j < row ;j++){
                if(isConnected[i][j] == 1){
                    unionFind.union(i,j);
                }
            }
        }
        int res = 0;
        for(int i =0; i<row ; i++){
            if (unionFind.parent[i] == i)
            {
                res++;
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
    public class UnionFind{

        private int[] parent;;

        public UnionFind(int x){
            parent = new int[x];
            for (int i = 0; i < x ; i++) {
                parent[i] = i;

            }
        }

        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }
        private int find(int x){
            if(x!= parent[x]){
                int cur = parent[x];
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public double Connected(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return 1;
            }else{
                return -1.0d;
            }
        }
    }

}
