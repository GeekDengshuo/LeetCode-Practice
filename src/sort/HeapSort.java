package src.sort;

/**
 * @Author deng shuo
 * @Date 6/3/21 21:10
 * @Version 1.0
 */
public class HeapSort {

    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        sort(nums);

        return nums[len - k];

    }
    public void sort(int[] arr){
        int N = arr.length;
        for(int k = N/2;k>=0;k--){
            sink(arr,k,N-1);
        }
        while(N > 1){
            exch(arr,0,--N);
            sink(arr,0,N-1);
        }
    }
    private void sink(int[] arr,int k,int N){
        while( 2*k <= N){
            int j = 2*k;
            if(j < N && less(arr[j],arr[j+1])) j++;
            if(!less(arr[k],arr[j])) break;
            exch(arr,k,j);
            k = j;
        }
    }
    private void exch(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private boolean less(int x,int y){
        return x < y;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("排序前:");
        for(int num:nums){
            System.out.print(num);
        }
        System.out.println();

        int res = heapSort.findKthLargest(nums,k);

        System.out.println("res = "+res);

        System.out.println("排序后:");
        for(int num:nums){
            System.out.print(num);
        }

    }
}
