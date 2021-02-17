package src.array;

/**
 * @Author deng shuo
 * @Date 2/17/21 20:23
 * @Version 1.0
 */
// python and MATLAB has "reshape" function
public class ReshapeMatrix_566 {
    /**
     *
     * @param nums original matrix
     * @param r  matrix rows
     * @param c  matrix columns
     * @return   reshape matrix
     */
    public int[][] matrixReshape(int[][] nums,int r,int c){

        int rows = nums.length;
        int cols = nums[0].length;

        // can't reshape
        if( rows * cols < r *c){
            return nums;
        }
        int[][] ReshapedMatrix = new int[r][c];
        for(int i = 0; i< rows;i++){
            for(int j= 0; j< cols;j++){
                int index = i * cols + j;
                int row = index / c;
                int col = index % c;
                ReshapedMatrix[row][col] = nums[i][j];
            }
        }
        return ReshapedMatrix;

    }

    private void printMatrix(int[][] nums){
        int rows = nums.length;
        int cols = nums[0].length;

        for(int i = 0; i< rows;i++){
            for(int j= 0; j< cols;j++){

                System.out.print(nums[i][j]);

            }
        }


    }

    public static void main(String[] args) {
        ReshapeMatrix_566 rm = new ReshapeMatrix_566();

        int[][] nums = {{1,2},{3,4}};

        int r = 1;
        int c = 4;

        int[][] res = rm.matrixReshape(nums,r,c);

        System.out.println("origin matrix:");
        System.out.println(nums);

        System.out.println("reshape matrix:");
        System.out.println(res);



    }
}
