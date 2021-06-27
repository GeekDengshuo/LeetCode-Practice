package src.test.leetcode0607;

import java.util.ArrayList;

/**
 * @Author deng shuo
 * @Date 6/27/21 10:46
 * @Version 1.0
 */
public class RotateMatrixGrid {
    public int[][] rotateGrid(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        int top = 0;
        int left = 0;
        int bottom = rows -1;
        int right = cols -1;

        // 顺时针遍历数组
        while(left <= right && top <= bottom){

            int first = grid[top][left];

            for(int i= left+1;i<=right;i++){
                grid[top][i-1] = grid[top][i];
            }
            top++;
            for(int i = top ;i<=bottom;i++){
                grid[i-1][right] = grid[i][right];
            }
            right--;
            for(int i= right;i>=left && top<=bottom ;i--){
                grid[bottom][i+1] = grid[bottom][i];
            }
            bottom--;
            for(int i= bottom;i>=top && left <=right;i--){

                grid[i+1][left] = grid[i][left];
            }
            grid[top][left] = first;

            left ++;
        }


        return grid;

    }

    public int[][] rotateGrid2(int[][] grid, int kk) {
        int n = grid.length, m = grid[0].length, level = Math.min(m, n) / 2;
        ArrayList<int[]> lists[] = new ArrayList[level];
        for(int i = 0; i < level; i++) lists[i] = new ArrayList();
        int rows = n, columns = m, l = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                lists[l].add(new int[]{top, column});
            }
            for (int row = top + 1; row <= bottom; row++) {
                lists[l].add(new int[]{row, right});
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    lists[l].add(new int[]{bottom, column});
                }
                for (int row = bottom; row > top; row--) {
                    lists[l].add(new int[]{row, left});
                }
            }
            left++;
            right--;
            top++;
            bottom--;
            //for(int[] tmp: lists[l]) System.out.print(tmp[0] + " " + tmp[1] + "   ");
            //System.out.println();
            l++;

        }
        int[][] res = new int[n][m];
        for(int i = 0; i < level; i++) {
            int mm = lists[i].size();
            int k = kk % mm;
            for(int j = 0; j < mm; j++) {
                int x = lists[i].get(j)[0], y = lists[i].get(j)[1];
                int x1 = lists[i].get((j + k) % mm)[0], y1 = lists[i].get((j + k) % mm)[1];
                res[x][y] = grid[x1][y1];
            }
        }
        return res;
    }
}
