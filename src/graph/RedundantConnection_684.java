package src.graph;

/**
 * @Author deng shuo
 * @Date 2021/1/13 22:20
 * @Version 1.0
 */
public class RedundantConnection_684 {

    public int[] findRedundantConnection(int[][] edges) {

        int len = edges.length;
        UnionFind unionFind = new UnionFind(len);
        for(int[] edge: edges){
            if(!unionFind.union(edge[0],edge[1])){
                return edge;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};

        System.out.println(edges.length);

        RedundantConnection_684 rc = new RedundantConnection_684();

        int[] result = rc.findRedundantConnection(edges);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }

        System.out.println(result);


    }

    public class UnionFind{

        private int[] parent;
        private int[] rank;

        UnionFind(int num){
            parent = new int[num+1];
            rank = new int[num+1];

            for (int i = 0; i < num+1; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return false;


            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else if(rank[rootY] > rank[rootX]){
                parent[rootX] = rootY;
            }else{
                parent[rootY] = rootX;
                rank[rootX] +=1;
            }
            return true;

        }

        private int find(int x){
            if(x!= parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnected(int x,int y){
            return find(x) == find(y);
        }
    }
}
