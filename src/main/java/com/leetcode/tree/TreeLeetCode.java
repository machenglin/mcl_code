package com.leetcode.tree;

/**
 * Created by Mcl on 2018/7/2.
 */
public class TreeLeetCode {
    /**
     * [3,9,20,null,null,15,7]
     *
     * @param root
     * @return
     */

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMaxDepth = 0;
        int rightMaxDepth = 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            leftMaxDepth = maxDepth(root.left);
        }
        if (root.right != null) {
            rightMaxDepth = maxDepth(root.right);
        }
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftMaxDepth = minDepth(root.left) ;
        int rightMaxDepth = minDepth(root.right);
        return Math.min(leftMaxDepth == 0?Integer.MAX_VALUE: leftMaxDepth, rightMaxDepth) + 1;
    }

    //private boolean isYeziNode(TreeNode node){
    //    return ;
    //}

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]){
                result += prices[i] - prices[i-1];
            }
        }
        return result;
    }
}

