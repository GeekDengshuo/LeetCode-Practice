package src.array;

/**
 * @Author deng shuo
 * @Date 2/24/21 20:41
 * @Version 1.0
 */
public class FlippingAnImage_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        for(int row = 0;row < rows;row++){
            flipArray(A[row]);
        }
        return A;
    }
    private void flipArray(int[] array){
        int len = array.length;
        int left= 0;
        int right = len -1;
        while(left < right){
            array[left] = array[left] == 0? 1:0;
            array[right] = array[right]== 0? 1:0;

            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        FlippingAnImage_832 flip = new FlippingAnImage_832();

        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(A);
        int[][] B =  flip.flipAndInvertImage(A);
        System.out.println(B);

        int a = 1;
        int b = 0;

        a = a & 1 & 0;
        b= b & 1& 0;
        System.out.println(a);
        System.out.println(b);
    }
}
