package com.problems.solving.tree;

public class LongestZigZagPath {

    public static int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        int leftPathLength = helper(root.left, false, 1);
        int rightPathLength = helper(root.right, true, 1);


        return Math.max(leftPathLength, rightPathLength);
    }

    static int helper(TreeNode root, boolean isRight, int count) {
        if (root == null) {
            return count - 1;
        }

        if (root.left == null && root.right == null) {
            return count - 1;
        }

        int rightPathLength = 0;
        int leftPathLength = 0;
        if (isRight) {
            leftPathLength = helper(root.left, false, count + 1);
            rightPathLength = helper(root.right, true, 1);
        } else {
            leftPathLength = helper(root.left, false, 1);
            rightPathLength = helper(root.right, true, count + 1);
        }
        return Math.max(leftPathLength, rightPathLength);
    }

    public static void main(String[] args) {
        System.out.println(longestZigZag(new TreeNode(1,new TreeNode(2,new TreeNode(4,null,null),null), new TreeNode(3,null,new TreeNode(3,null,new TreeNode(5,null,null))))));
    }
}
