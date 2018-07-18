package com.leetcode.linked;

import java.util.Stack;

/**
 * Created by Mcl on 2018/7/5.
 */
public class LinkedLeetCode {
    public void deleteNode(ListNode node, int val) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&& fast.next !=null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        while(slow!=null){
            if(slow.val != stack.pop()){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode node = new ListNode(head.val);
        if(node == null){
            return node;
        }
        node.next=head.next;
        ListNode next = node.next;
        node.next = null;
        return swap(node, next);
    }

    static ListNode swap(ListNode first, ListNode second){
        if(second == null){
            return first;
        }
        ListNode next = second.next;
        second.next = first;
        return swap(second, next);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode node   = null;
        int value ;
        while (l1!=null && l2!=null){

            if(l1.val <= l2.val ){
                value = l1.val;
                l1=l1.next;
            }else{
                value = l2.val;
                l2=l2.next;
            }
            if(result==null){
                node = new ListNode(value);
                result = node;
            }else{
                node.next = new ListNode(value);
                node=node.next;
            }

        }
        if(result == null && l1!=null){
            return l1;
        }
        if(result ==null && l2!=null){
            return l2;
        }
        if(node!= null && l1!=null){
            node.next = l1;
        }
        if(node!= null && l2!=null){
            node.next = l2;
        }
        return result;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
    return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        head.next = next1;
        ListNode next2 = new ListNode(2);
        next1.next = next2;
        ListNode next3 = new ListNode(1);
        next2.next = next3;

        //reverseList(head);
        //mergeTwoLists(head, head);
        System.out.println(isPalindrome(head));
    }

}
