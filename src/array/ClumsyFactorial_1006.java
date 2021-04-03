package src.array;

/**
 * @Author deng shuo
 * @Date 4/1/21 07:17
 * @Version 1.0
 */
public class ClumsyFactorial_1006 {
    public static int clumsy(int N){
           if(N==1) return 1;

           int curClumsy = N;
           int cur = 0;
           while(N-- >1){
               if(cur %4 == 0){
                   curClumsy *= N;
               }else if(cur %4 == 1){
                   curClumsy = (int)curClumsy / N;  // floor division
               }else if(cur %4 == 2){
                   curClumsy += N;
               }else{
                   curClumsy -= N;
               }
               cur++;
           }

           return curClumsy;
        }

    public static void main(String[] args) {
        int n = 10;
        int result = clumsy(n);

        System.out.println(result);
    }
}
