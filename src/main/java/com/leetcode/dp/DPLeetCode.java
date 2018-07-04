package com.leetcode.dp;

/**
 * Created by Mcl on 2018/7/2.
 */
public class DPLeetCode {
    /**
     * 最大和子序列
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sumArray1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sumArray1 < 0 && nums[i] >= 0 || nums[i] < 0 && nums[i] >= max) {
                max = nums[i] > max ? nums[i] : max;
                sumArray1 = nums[i];
            }else{
                sumArray1 += nums[i];
                max = sumArray1 > max ? sumArray1 : max;
            }
        }
        return max;
    }


}
