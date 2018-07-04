package com.leetcode.array;

import com.leetcode.utils.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Mcl on 2018/7/4.
 */
public class ArrayLeetCode {
    public static void main(String[] args) {
        //rotate2(new int[]{-1},2);
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
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
        Arrays.sort(nums);
        int result = nums[0];
        for(int i =1;i<nums.length;i++){
            if(nums[i] == result){
                continue;
            }
            result = nums[i];
            if(i +1 < nums.length && result != nums[i+1] && ){
                return result;
            }
        }
        return result;
    }
}
