package src.dp;

import java.util.*;

/**
 * @Author deng shuo
 * @Date 2021/1/29 21:48
 * @Version 1.0
 */
public class PathWithMinimumEffort_1631 {

    /**
     * 错误的方法
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = 0;

        for(int row = 1; row < rows; row++){
            dp[row][0] = heights[row][0] - heights[row-1][0];
        }
        for(int col = 1; col < cols; col++){
            dp[0][col] = heights[0][col] - heights[0][col -1];
        }

        for(int row = 1;row < rows; row++){
            for(int col = 1;col < cols;col++){
                dp[row][col] = Math.min(dp[row-1][col],dp[row][col-1]);
            }
        }
        return  dp[rows-1][cols -1];

    }

    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Collections.sort(edges, (edge1, edge2) -> edge1[2] - edge2[2]);

        UnionFind uf = new UnionFind(m * n);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.unite(x, y);
            if (uf.connected(0, m * n - 1)) {
                ans = v;
                break;
            }
        }
        return ans;
    }
}

// 并查集模板
class UnionFind {
    int[] parent;
    int[] size;
    int n;
    // 当前连通分量数目
    int setCount;

    public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    public boolean unite(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    public boolean connected(int x, int y) {
        x = findset(x);
        y = findset(y);
        return x == y;
    }
}
