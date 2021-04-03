package src.array;

/**
 * @Author deng shuo
 * @Date 3/30/21 07:28
 * @Version 1.0
 */
public class Search2dMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols -1;

        while(row < rows && col >=0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;

    }

}
