package src.dp;

/**
 * @Author deng shuo
 * @Date 2021/1/9 20:09
 * @Version 1.0
 */
public class BestTimeToBuyAndSellStockIII_123 {

    public static int MaxProfit(int[] prices){

        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for(int price : prices){
            firstBuy = Integer.max(firstBuy,-price);
            firstSell = Integer.max(firstSell,firstBuy + price);
            secondBuy = Integer.max(secondBuy,firstSell - price);
            secondSell = Integer.max(secondSell,secondBuy + price);
        }
        return secondSell;

    }

    public static void main(String[] args) {
        int prices[] = {3,3,5,0,0,3,1,4};

        int result = MaxProfit(prices);

        for(int p: prices){
            System.out.print(p+ " ");
        }
        System.out.println();

        System.out.println("maxProfit for two buy and sell = ");
        System.out.println(result);
    }
}
