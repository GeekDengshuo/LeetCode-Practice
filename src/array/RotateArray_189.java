package src.array;

/**
 * @Author deng shuo
 * @Date 2021/1/8 23:10
 * @Version 1.0
 */

//O(1) time
public class RotateArray_189 {

    public void rotate(int[] num,int k){
        // error input
        if(k < 0) return ;
        int len = num.length;
        k = k % len;

        reverse(num,0,len-k-1);
        reverse(num,len-k,len-1);
        reverse(num,0,len-1);


    }

    private void reverse(int[]num,int start,int end){
        if(start >= end) return ;
        int left = start;
        int right = end;
        while(left < right){
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RotateArray_189 rotate_arr = new RotateArray_189();
        int [] num1 ={1,2,3,4,5,6,7};
        int k = 3;
        for (int i = 0; i <num1.length ; i++) {
            System.out.print(num1[i]+" ");
        }
        System.out.println(" ");

        rotate_arr.rotate(num1,k);

        for (int i = 0; i <num1.length ; i++) {
            System.out.print(num1[i]+" ");
        }
        System.out.println(" ");

    }
}
