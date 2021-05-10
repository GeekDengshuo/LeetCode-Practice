package src.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 5/2/21 11:05
 * @Version 1.0
 */
public class BrickWall_544 {

    // 超出时间限制
    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();

        int least = height;
        int width = 0;
        for(int num:wall.get(0)){
            width +=num;
        }
        int count = 0;
        for(int i=1;i<width;i++){
            for(List<Integer> rows: wall){
                count += hasWidth(rows,i);
            }
            least = Math.min(least,height - count);
        }
        return least;

    }

    private int hasWidth(List<Integer> rows,int width){
        int curSum = 0;
        for(int row: rows ){
            curSum+=row;
            if(curSum == width){
                return 1;
            }
        }
        return 0;
    }

    public int leastBricks2(List<List<Integer>> wall){

        Map<Integer,Integer> numCount = new HashMap<>();

        for(List<Integer> row : wall){
            int curRes = 0;
            for(int i = 0;i < row.size() -1;i++){
                curRes += row.get(i);

                numCount.put(curRes,numCount.getOrDefault(curRes,0)+1);
            }
        }
        int count = 0;
        for(int value: numCount.values()){
            if(value > count){
                count = value;
            }
        }
        return wall.size() - count;


    }
}
