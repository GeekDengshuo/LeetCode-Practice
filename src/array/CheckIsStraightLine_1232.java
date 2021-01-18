package src.array;

/**
 * @Author deng shuo
 * @Date 2021/1/17 20:33
 * @Version 1.0
 */
public class CheckIsStraightLine_1232 {

    public boolean checkStraightLine(int[][] coordinates) {

        int len = coordinates.length;

        if (len <=2 ) return true;

        int yStart = coordinates[0][1];
        int xStart = coordinates[0][0];
        int yEnd = coordinates[len-1][1];
        int xEnd = coordinates[len-1][0];;

        for(int[]points:coordinates){
            if ((yEnd - points[1])*(points[1] - xStart) != (points[1] - yStart)*(xEnd - points[0])){
                return false;

            }
        }
        return true;


    }
}
