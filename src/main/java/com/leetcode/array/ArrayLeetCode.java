package com.leetcode.array;

import com.leetcode.utils.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Mcl on 2018/7/4.
 */
public class ArrayLeetCode {
    public static void main(String[] args) {
        //rotate2(new int[]{-1},2);
        //System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        ArrayUtils.printArr(plusOne(new int[]{9}));

    }
    public  static  void rotate(int[] nums, int k) {
        for(int i = 1; i<=k;i++){
            int tmp = nums[nums.length-1];
            System.arraycopy(nums, 0, nums, 1, nums.length-1);
            nums[0] = tmp;
        }
        ArrayUtils.printArr(nums);
    }
    public  static  void rotate2(int[] nums, int k) {
        k = k%nums.length;
        int[] tmp = new int[k];
        System.arraycopy(nums, nums.length - k, tmp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(tmp, 0, nums, 0, k);
        ArrayUtils.printArr(nums);
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if(nums[nums.length-1]!= nums[nums.length-2]){
            return nums[nums.length-1];
        }

        for(int i =1;i<nums.length-2;i++){
            if(nums[i]!= nums[i-1] && nums[i]!=nums[i+1]){
                return nums[i];
            }

        }
        return 0;
    }
    //public int[] intersect(int[] nums1, int[] nums2) {
    //
    //}
    public static int[] plusOne(int[] digits) {
        if(digits[digits.length-1] != 9){
            digits[digits.length-1] = digits[digits.length-1]+1;
            return digits;
        }
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] == 9){
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
            if(i == 0){
                int[] result = new int[digits.length+1];
                result[0]=1;
                System.arraycopy(digits,0,result,1,digits.length);
                return result;
            }
        }
        return digits;
    }
}
