package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mcl on 2018/6/29.
 */
public class LeetCode {

    private static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public static int[] twoSum(int[] nums, int target) {
        int mid = binarySearch(nums, target / 2);
        for (int i = mid; i >= 0; i--) {
            for (int j = mid; j < nums.length; j++) {
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

    private static int binarySearch(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int mid = (begin + end) / 2;
        while (1 < end - begin) {
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                begin = mid;
            } else {
                return mid;
            }
            mid = (begin + end) / 2;
        }
        return mid;
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

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1) == -1) {
                return i;
            }
        }
        return -1;
    }

    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        if (c1.length != c2.length) {
            return false;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        String pattern = "[^a-z0-9A-Z]";
        String s1 = s.replaceAll(pattern, "").toLowerCase();
        return new StringBuilder(s1).reverse().toString().equals(s1.toLowerCase());
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        int sign = 1;
        long base = 0;
        int i = 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            base = base * 10 + (str.charAt(i++) - '0');
            if (base * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (base * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }


        }
        return (int) (base * sign);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public static int hammingWeight(int n) {
//        int result = 0;
//        while (n>0){
//            if(n%2 == 1){
//                result++;
//            }
//            n = n/2;
//        }
//        int res = 0;
//        for(int i = 0 ; i < 32 ; i ++) {
//            res += (n%2);
//            n /= 2;
//        }
        int ans = 0;
        String s = Integer.toBinaryString(n);
        for (char i : s.toCharArray()) {
            if (i == '1')
                ans++;
        }
        return ans;
//        return res;
//        return result;
    }

    public static boolean isPowerOfThree(int n) {
        while (n >= 3) {
            n = n / 3;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    public static int[] intersect(Integer[] nums1, Integer[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
//            list.add(nums1)
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ints = new int[list.size()];
        int k = 0;
        for (Integer anInt : list) {
            ints[k++] = anInt;
        }
        return ints;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer("");
        int index = 0;
        if (strs.length == 0) {
            return sb.toString();
        }
        while (true) {
            try {
                char c = strs[0].charAt(index);
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() < index) {
                        return sb.toString();
                    }
                    if (strs[i].charAt(index) != c) {
                        return sb.toString();
                    }
                }
                sb.append(c);
                index++;
            } catch (Exception ignore) {
                return sb.toString();
            }

        }
    }

    public static void main(String[] args) {
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
//        System.out.println(reverse(120));
//        System.out.println(firstUniqChar("loveleetcode"));
//        isPalindrome("lovelee.1.3tcode");

//        System.out.println(hammingWeight(128));
//        System.out.println(hammingWeight(214748648));
//        System.out.println((Integer.MAX_VALUE));
//        isPowerOfThree(27);
        String[] strings = {"a"};
        longestCommonPrefix(strings);
    }
}
