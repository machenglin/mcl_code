package com.algorithm;

import java.util.Arrays;

/**
 * Created by Mcl on 2018/6/20.
 */
public class BinarySearchTest {
    public static int binarySearch(int[] arr, int key) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (key > arr[mid]) {
                begin = mid + 1;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {11,2,3,5,7,88,4,12,6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 7));
    }

}
