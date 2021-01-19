package src.graph;

import java.util.PriorityQueue;

/**
 * @Author deng shuo
 * @Date 2021/1/19 22:02
 * @Version 1.0
 */
// 最小生成树
public class MinCostToConnectAllPoints_1584 {

    private int[] parent;
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.dis - e2.dis);
        int n = points.length;
        parent = new int[n];
        int count = 1;
        for (int i = 0; i < n; i ++){
            parent[i] = i;
            for (int j = i + 1; j < n; j ++){
                Edge e = new Edge(points, i, j);
                queue.add(e);
            }
        }
        int res = 0;
        while (!queue.isEmpty()){
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            int dis = e.dis;
            if (!isUnion(x, y)){
                union(x,y);
                res += dis;
                count ++;
            }
            if (count == n){
                break;
            }
        }
        return res;
    }
    private int getParent(int i){
        while (i != parent[i]){
            int temp = parent[i];
            parent[i] = parent[temp];
            i = parent[i];
        }
        return i;
    }

    private boolean isUnion(int i, int j){
        int pi = getParent(i);
        int pj = getParent(j);
        return pi == pj;
    }

    private void union(int i, int j){
        int pi = getParent(i);
        int pj = getParent(j);
        if (pi != pj){
            parent[pj] = pi;
        }
    }

    class Edge{
        int x;
        int y;
        int dis;
        Edge(int[][] points, int i, int j){
            x = i;
            y = j;
            dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
        }
    }

}
