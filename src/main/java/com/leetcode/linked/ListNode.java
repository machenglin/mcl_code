package com.leetcode.linked;

/**
 * Created by Mcl on 2018/7/5.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    static void print(ListNode head){
        System.out.println(head.val);
        while (head.next!=null){
            head = head.next;
            System.out.println(head.val);
        }
    }
}
