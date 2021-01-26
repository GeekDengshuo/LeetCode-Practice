package src.graph;

/**
 * @Author deng shuo
 * @Date 2021/1/23 10:44
 * @Version 1.0
 */

/***
 * 联通网络的操作次数
 */
public class NumberOfOperationsToMakeNetworkConnected_1319 {

    //public int redundant = 0;

    /**
     * 主实现函数
     * @param n   计算机网络结点个数
     * @param connections   网络结点的连通数组
     * @return    NumberOfOperationsToMakeNetworkConnected，
     */
    public int makeConnected(int n,int[][] connections){

        int result = -1;
        UnionFind unionFind = new UnionFind(n);

        for(int[] connection : connections){
            //if(unionFind.isConnected(connection[0],connection[1])){
            //    redundant++;
            //}
            unionFind.union(connection[0],connection[1]);
        }
        //if(redundant + unionFind.count +1 == n){
        //    result = redundant;
        //}
        return unionFind.count - 1;

    }

    class UnionFind{
        private int[] parent;
        private int[] rank;

        public int count;

        UnionFind(int num){
            parent = new int[num];
            rank = new int[num];
            count = num;
            for (int i = 0; i < num; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)
                return ;
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
                count++;
            }else{
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
                count++;
            }

        }

        public boolean isConnected(int x,int y){
            return find(x) == find(y);
        }

        private int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

    }
}
