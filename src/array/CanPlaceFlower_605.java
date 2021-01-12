package src.array;

/**
 * @Author deng shuo
 * @Date 2021/1/12 22:00
 * @Version 1.0
 */
public class CanPlaceFlower_605 {

    public boolean canPlaceAllFlower(int[] flowerbed,int n){
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }

    public static boolean canPlaceAllFlower2(int[] flowerbed,int n){
        for(int i =0 ;i< flowerbed.length;i++){
            if(flowerbed[i] == 0
                    && (i == 0 || flowerbed[i-1] == 0)
                    && (i == flowerbed.length -1 || flowerbed[i+1]==0))
            {
                flowerbed[i] = 1;
                n --;
            }
        }
        return n<=0;
    }

    public static void main(String[] args) {
        int[] flower = {1,0,0,0,1};
        int n = 1;

        boolean result = canPlaceAllFlower2(flower,n);

        System.out.println(result);

    }
}
