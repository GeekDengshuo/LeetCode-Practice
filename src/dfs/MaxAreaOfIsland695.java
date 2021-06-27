package src.dfs;

/**
 * @Author deng shuo
 * @Date 6/19/21 17:39
 * @Version 1.0
 */
public class MaxAreaOfIsland695 {

    public int [][] grid;

    public static int[] dx = new int[]{1,-1,0,0};
    public static int[] dy = new int[]{0,0,1,-1};

    private int rows,cols;

    private boolean visited[][];

    public int maxArea = 0;

    public boolean notLand = false;

    public int curArea;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                notLand = false;
                if(!visited[i][j]){
                    curArea = 0;
                    dfs(i,j);

                    if(!notLand){
                        maxArea = maxArea>curArea ? maxArea:curArea;
                    }

                }
            }
        }


        return maxArea;
    }

    public void dfs(int row,int col){
        if(row < 0 || col <0 || row >= rows || col >=cols || grid[row][col] == 0){
            notLand = true;
            return;
        }
        curArea++;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            dfs(row+dx[i],col+dy[i]);
        }

    }
}
