package com.leetcode.soft;

/**
 * Created by Mcl on 2018/7/3.
 */
public class SoftLeetCode {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println();
        printArr(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int mi = 0, ni = 0;
        int index = 0;
        while (mi < m && ni < n) {
            if (nums1[mi] < nums2[ni]) {
                result[index++] = nums1[mi++];
            } else {
                result[index++] = nums2[ni++];
            }
        }
        for (; mi < m; mi++) {
            result[index++] = nums1[mi];
        }
        for (; ni < n; ni++) {
            result[index++] = nums2[ni];
        }
        for(int i =0;i<m+n;i++){
            nums1[i] = result[i];
        }
        printArr(nums1);
    }

    static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
