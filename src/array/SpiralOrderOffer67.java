package src.array;

/**
 * @Author deng shuo
 * @Date 6/27/21 14:45
 * @Version 1.0
 *
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 16 17 18 19 20
 */
public class SpiralOrderOffer67 {
    public int[] spiralOrder(int[][] matrix) {

        int rows = matrix.length;
        int cols= matrix[0].length;
        int top = 0 ,left = 0;
        int bottom = rows-1,right = cols-1;

        int[] result  = new int[rows * cols];
        int cur = 0;

        while(left <= right && top <= bottom){

            for(int i = left;i<=right ;i++){
                result[cur++] = matrix[top][i];
            }
            for(int i = top+1;i<= bottom;i++){
                result[cur++] = matrix[i][right];
            }
            if(left < right && top < bottom){
                for(int i = right-1;i>left;i--){
                    result[cur++] = matrix[bottom][i];
                }
                for(int i = bottom;i>top;i--){
                    result[cur++] = matrix[i][left];
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return result;
    }
}
