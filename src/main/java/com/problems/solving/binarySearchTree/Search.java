package com.problems.solving.binarySearchTree;

import com.problems.solving.tree.TreeNode;

public class Search {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode result;
        if (root.getVal() == val) {
            result = root;
            return result;
        }

        if (root.getVal() > val) {
            result = searchBST(root.getLeft(), val);
        } else {
            result = searchBST(root.getRight(), val);
        }
        return result;
    }
}
