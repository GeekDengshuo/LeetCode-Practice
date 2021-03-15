package src.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author deng shuo
 * @Date 3/15/21 21:00
 * @Version 1.0
 */
public class SpiralMatrix_54 {
    /**
     *  这个方法会出现 数组越界
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> res = new LinkedList<>();

        int row = 0;
        int col = 0;

        while(true){
            //1. row = 0 col = 1 -> cols-1
            while(col < cols){
                res.add(matrix[row][col]);
                col++;
            }

            row++;

            //2. col = cols -1 ; row = 1 - rows-1
            while(row < rows){
                res.add(matrix[row][col]);
                row++;
            }

            col--;
            // 3. row = rows - 1; col = cols-1 -> 0;
            while(col >=0){
                res.add(matrix[row][col]);
                col--;
            }

            // 4. row = rows -1 -> 1; col = 0
            row--;
            while(row >= rows -2){
                res.add(matrix[row][col]);
                row--;
            }

            col++;

            if(col == cols || row == rows){
                break;
            }
        }

        return res;

    }


    public static List<Integer> spiralOrder2(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;

        List<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right){

            for(int col = left ;col <= right;col++){
                res.add(matrix[top][col]);
            }

            for(int row = top+1 ; row <= bottom;row++){
                res.add(matrix[row][right]);
            }

            if(top < bottom && left <right){
                for(int col = right-1; col > left ;col--){
                    res.add(matrix[bottom][col]);
                }
                for(int row = bottom; row > top; row --){
                    res.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;


        }
        return res;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list){
            System.out.print(e.intValue() + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};


        List<Integer> res1 = spiralOrder2(matrix);

        List<Integer> res2 = spiralOrder2(matrix2);

        printList(res1);

        printList(res2);


    }
}
