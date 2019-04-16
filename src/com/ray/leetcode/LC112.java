package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/15.
 *
 * Path Sum -Level E
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class LC112 {
    /*
     * 树的路径遍历
     * 深度优先、 广度优先
     * 这里使用深度优先来实现
     *
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        return hasPathSum1(root, sum);
    }

    /**
     * 递归实现
     * @param node
     * @param sum
     * @return
     */
    private  boolean hasPathSum1(TreeNode node, int sum) {

        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                return true;
            }
            return false;
        }
        boolean leftHasPathSum = false;
        boolean rightHasPathSum = false;
        if (node.left != null) {
            leftHasPathSum = hasPathSum1(node.left , sum - node.val);
        }

        if (node.right != null) {
            rightHasPathSum = hasPathSum1(node.right , sum - node.val);
        }
        return leftHasPathSum ? leftHasPathSum : rightHasPathSum;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right =  new TreeNode(-3);
       // root.right.left = new TreeNode(-5);

        System.out.println(new LC112().hasPathSum(root, -5));
    }
}
