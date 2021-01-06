package src.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 2021/1/6 21:35
 * @Version 1.0
 */
//  use union find
public class EvaluateDivision_399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int equationsSize = equations.size();

        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        Map<String,Integer> hashMap = new HashMap<>(2*equationsSize);

        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String str1 = equation.get(0);
            String str2 = equation.get(1);

            if(!hashMap.containsKey(str1)){
                hashMap.put(str1,id);
                id++;
            }
            if(!hashMap.containsKey(str2)){
                hashMap.put(str2,id);
                id++;
            }
            unionFind.union(hashMap.get(str1),hashMap.get(str2),values[i]);
        }
        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] result = new double[queriesSize];

        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if(id1 == null || id2 == null){
                result[i] = -1.0d;
            }else{
                result[i] = unionFind.isConnected(id1,id2);
            }

        }
        return result;
    }

    public class UnionFind{

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;

        UnionFind(int x){
            this.parent = new int[x];
            this.weight = new double[x];
            for (int i = 0; i < x ; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }

        }

        public void union(int x,int y,double value){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];


        }

        // 路径压缩
        private int find(int x){
            if(x != parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }

    }
    public static void main(String[] args) {

    }
}
