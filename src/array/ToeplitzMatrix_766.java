package src.array;

/**
 * @Author deng shuo
 * @Date 2/22/21 21:16
 * @Version 1.0
 */

/**
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同
 * 那么这个矩阵是 托普利茨矩阵
 */
public class ToeplitzMatrix_766 {
    public boolean isToeplitzMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0;i < rows;i++){
            if( !diagonalMatrix(matrix,i,0,rows,cols)){
                return false;
            }
        }
        for(int j= 0; j< cols;j++){
            if(!diagonalMatrix(matrix,0,j,rows,cols)){
                return false;
            }
        }
        return true;

    }

    private boolean diagonalMatrix(int[][] matrix,int row,int col,int rows,int cols){
        if(row >= rows || col >= cols) return false;

        int diagonalNum = matrix[row][col];
        while(row < rows && col < cols){
            if(matrix[row][col] != diagonalNum){
                return false;
            }
            row+=1;
            col+=1;
        }
        return true;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        ToeplitzMatrix_766 toeplitzMatrix = new ToeplitzMatrix_766();
        boolean result = toeplitzMatrix.isToeplitzMatrix(matrix);
        System.out.println(result);
    }


}
