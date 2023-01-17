package com.problems.solving.tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<>();
        binaryTreeNodeQueue.add(root);
        while (!binaryTreeNodeQueue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int index = 0; index < binaryTreeNodeQueue.size(); index++) {
                BinaryTreeNode node = binaryTreeNodeQueue.remove();
                if (node != null) {
                    level.add(node.val);
                    binaryTreeNodeQueue.add(node.left);
                    binaryTreeNodeQueue.add(node.right);
                }
            }
            if (!level.isEmpty()) {
                result.add(level);
            }
        }
        return result;
    }
}
