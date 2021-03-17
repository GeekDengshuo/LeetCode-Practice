package src.array;

/**
 * @Author deng shuo
 * @Date 3/16/21 21:06
 * @Version 1.0
 */
public class SpiralMatrixII_59 {

    public int[][] GenerateSpiralMatrix(int n){
        int[][] matrix = new int[n][n];

        int top = 0;
        int left = 0;
        int right = n -1;
        int bottom = n -1;

        int count = 1;

        while(top <= bottom && left <= right){

            for(int col = left; col <= right ;col++){
                matrix[top][col] = count++;
            }

            for(int row = top+1 ; row <= bottom ;row++){
                matrix[row][right] = count++;
            }

            if(top < bottom && left < right){
                for(int col = right -1 ;col > left ;col --){
                    matrix[bottom][col] = count++;
                }
                for(int row = bottom ; row > top ;row --){
                    matrix[row][left] = count++;
                }
            }

            left++;
            top++;
            right--;
            bottom--;

        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII_59 spm = new SpiralMatrixII_59();

        int[][] matrix = spm.GenerateSpiralMatrix(1);

        System.out.println(matrix);

        for(int i= 0;i< matrix.length;i++){
            for(int j = 0;j< matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }



    }
}
