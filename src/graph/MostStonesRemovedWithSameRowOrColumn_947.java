package src.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 2021/1/15 22:16
 * @Version 1.0
 */
public class MostStonesRemovedWithSameRowOrColumn_947 {

    public int removeStones(int[][] stones) {
        int len = stones.length;
        if(len == 0) return 0;
        UnionFind unionFind = new UnionFind();


        for(int[] stone: stones){
            // 进行两组的归并操作
            unionFind.union(stone[0]+10000,stone[1]);
        }

        return len - unionFind.getCount();

    }

    public class UnionFind{

        private Map<Integer,Integer> parent;

        private  int count;

        public UnionFind(){
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return ;
            }
            parent.put(rootX,rootY);
            count --;

        }

        public int find(int x){
            if(!parent.containsKey(x)){
                parent.put(x,x);
                count++;
            }
            if(x != parent.get(x)){
                parent.put(x,find(parent.get(x)));
            }
            return parent.get(x);
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {

    }
}
