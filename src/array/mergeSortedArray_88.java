package src.array;

import java.util.Arrays;

/**
 * @Author deng shuo
 * @Date 4/5/21 11:02
 * @Version 1.0
 */
public class mergeSortedArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = Arrays.copyOf(nums1,m);

        int i = 0;
        int j = 0;
        int index = 0;
        while(i< m || j<n){
            if(i==m) nums1[index] = nums2[j++];
            if(j==n) nums1[index] = nums1[i++];
            if(nums1_copy[i] < nums2[j]){
                nums1[index] = nums1_copy[i++];
            }else{
                nums1[index] = nums2[j++];
            }
            index++;
        }

    }
}
