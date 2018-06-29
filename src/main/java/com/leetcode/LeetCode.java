package com.leetcode;

/**
 * Created by Mcl on 2018/6/29.
 */
public class LeetCode {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    private static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long result = 0;
        int abs = Math.abs(x);
        while (abs % 10 == 0) {
            abs = abs / 10;
        }
        while (abs > 0) {
            result = result * 10 + (abs % 10);
            abs = abs / 10;
        }
        if (Math.abs(result) > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (x >= 0 ? result : -result);
    }

    public int peakIndexInMountainArray(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        int mid = (begin + end) / 2;
        while (A[mid] <= A[mid - 1] || A[mid] <= A[mid + 1]) {
            if (A[mid] > A[mid - 1]) {
                begin = mid;
            } else {
                end = mid;
            }
            mid = (begin + end) / 2;
        }
        return mid;
    }

    //public int findDuplicate(int[] nums) {
    //
    //}
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}
