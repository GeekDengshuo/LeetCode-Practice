package src.sort;


/**
 * @Author deng shuo
 * @Date 2020/12/30 21:13
 * @Version 1.0
 */
public class myQuickSort {

    private void swapValue(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int Partition(int [] nums,int left,int right){
        if(left >= right) return -1;
        int pivot = nums[left];
        int i = left;
        int j = right + 1;
        while(true){
            while(nums[++i] < pivot) if(i == right) break;
            while(nums[--j] > pivot) if(j == left) break;
            if(i >= j) break;
            swapValue(nums,i,j);
        }
        swapValue(nums,left,j);
        return j;
    }

    private void QuickSortAlgorithm(int[] nums,int start,int end){
        if(start >= end) return;
        int mid = Partition(nums,start,end);
        QuickSortAlgorithm(nums,start,mid-1);
        QuickSortAlgorithm(nums,mid+1,end);
    }
    public static void main(String[] args) {

        int[] nums = {3,2,1,6,7};
        int len = nums.length;
        System.out.println("before quick sort:");
        for(int cur:nums){
            System.out.println(cur);

        }
        myQuickSort myQuickSort = new myQuickSort();
        myQuickSort.QuickSortAlgorithm(nums,0,len-1);
        System.out.println("after quick sort:");
        for(int cur:nums){
            System.out.println(cur);
        }


    }
}
