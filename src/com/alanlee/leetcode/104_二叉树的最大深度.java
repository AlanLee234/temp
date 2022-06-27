package com.alanlee.leetcode;

import com.alanlee.basics.structure.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
/*
 * labuladong 东哥带你刷二叉树（纲领篇）
 */
class Solution {
    int ans = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return ans;
        }
        traverse(root, 1);
        return ans;
    }

    public void traverse(TreeNode root, int length) {
        if (length > ans) {
            ans = length;
        }
        if (root.left != null) {
            traverse(root.left, length + 1);
        }
        if (root.right != null) {
            traverse(root.right, length + 1);
        }
    }

    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;

    // 主函数
    int maxDepth2(TreeNode root) {
        traverse2(root);
        return res;
    }

    // 二叉树遍历框架
    void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        traverse2(root.left);
        traverse2(root.right);
        // 后序位置
        depth--;
    }

    // 定义：输入根节点，返回这棵二叉树的最大深度
    int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        int res = Math.max(leftMax, rightMax) + 1;

        return res;
    }
}
// @lc code=end
