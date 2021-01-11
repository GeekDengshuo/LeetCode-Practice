package src.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author deng shuo
 * @Date 2021/1/11 21:28
 * @Version 1.0
 */
public class SmallestStringsWithSwap_1202 {

    public String smallestStringWithSwap(String s,List<List<Integer>> pairs){
        if(pairs.size() ==0) return s;

        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }

        char[] charArray = s.toCharArray();

        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {

            int root = unionFind.find(i);
            if(hashMap.containsKey(root)){
                hashMap.get(root).offer(charArray[i]);

            }else{
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(charArray[i]);
                hashMap.put(root,minHeap);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }

        return stringBuilder.toString();



    }

    public static void main(String[] args) {

    }


    public class UnionFind{

        private int[] parent;

        private int[] rank;   // 按秩合并,降低树的高度

        private int count;

        public UnionFind(int x){
            this.count = x;
            this.parent = new int[x];
            this.rank = new int[x];
            for (int i = 0; i <x ; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }
        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return ;
            }
            if(rank[rootX] == rank[rootY]){
                parent[rootX] = rootY;
                rank[rootY]++;
            }else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else{
                parent[rootX] = rootY;
            }
            count --;
        }

        private int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]) ;

            }
            return parent[x];
        }
        public boolean isConnected(int x,int y){
            return find(x) == find(y);
        }

        public int getCount(){
            return count;
        }
    }
}
