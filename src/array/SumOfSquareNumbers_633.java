package src.array;

/**
 * @Author deng shuo
 * @Date 4/28/21 21:30
 * @Version 1.0
 */
public class SumOfSquareNumbers_633 {
    public boolean judgeSquareSum(int c) {

        if(c == 0) return true;

        int sqrt = (int) Math.sqrt(c);


        int mid = sqrt/2;

        for(int i= 0;i<=mid;i++){
            for(int j= mid;j<=sqrt;j++){
                if(i*i + j*j == c){
                    return true;

                }
            }
        }
        return false;

    }

    public boolean judge(int c){
        int i=0;
        int j=(int)Math.sqrt(c);

        while(i<=j){
            int sum=i*i+j*j;
            if(sum==c){
                return true;
            }else if(sum<c){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfSquareNumbers_633 sumSquare = new SumOfSquareNumbers_633();

        System.out.println(sumSquare.judgeSquareSum(4));
        System.out.println(sumSquare.judgeSquareSum(169));
        System.out.println(sumSquare.judgeSquareSum(5));
        System.out.println(sumSquare.judgeSquareSum(3));
    }

}
