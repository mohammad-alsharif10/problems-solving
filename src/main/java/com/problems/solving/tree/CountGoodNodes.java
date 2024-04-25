package com.problems.solving.tree;

public class CountGoodNodes {

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    int countGoodNodes(TreeNode root, int max) {
        int reult = 0;
        if (root == null) {
            return reult;
        }

        if (root.val >= max) {
            reult = 1;
            max = root.val;
        }
        reult += countGoodNodes(root.left, max);
        reult += countGoodNodes(root.right, max);
        return reult;
    }


}
