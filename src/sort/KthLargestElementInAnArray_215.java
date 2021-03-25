package src.sort;

/**
 * @Author deng shuo
 * @Date 3/25/21 22:34
 * @Version 1.0
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  k >=1 && k <= 10000
 */
public class KthLargestElementInAnArray_215 {

    //  1.use priority queue ( heap sort)
    public int findKLargest(int nums[] ,int k){

        Queue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    private void swap(int[] nums,int index1,int index2){
        int mid = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = mid;
    }
    private int partition(int nums[] ,int i,int j){

        if(i > j) return -1;
        int left = i;
        int right = j+1;

        int flagNum = nums[left];

        while(true){
            while(flagNum > nums[++left]) {
                if (left == j) break;
            }
            while(nums[--right] >flagNum){
                if(right == i) break;
            }
            if(left > right) break;
            swap(nums,left,right);
        }
        swap(nums,i,right);

        return right;
    }

    // 2.implement quick sort
    private int findKLargestPartition(int nums[],int k){
        int left = 0;
        int right = nums.length -1;

        k=nums.length-k;

        while(left < right){
            int index = partition(nums,left,right);

            if(index == k) break;

            else if(index >k){
                right = index -1;
            }else{
                left = index +1;
            }

        }
        return nums[k];
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray_215 largeElement = new KthLargestElementInAnArray_215();

        int nums[] = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        int result = largeElement.findKLargest(nums,k);

        int result2 = largeElement.findKLargestPartition(nums,k);

        System.out.println("kth element: "+result);

        System.out.println("partition kth element:" + result2);

    }

}
