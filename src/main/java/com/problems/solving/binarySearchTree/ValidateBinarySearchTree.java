package com.problems.solving.binarySearchTree;

import javax.sound.midi.Soundbank;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(BinaryTreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public static boolean isValid(BinaryTreeNode node, Long upperBound, Long lowerBound) {
        if (node == null) {
            return true;
        }
        if (!(node.val < upperBound && node.val > lowerBound)) {
            return false;
        }
        return isValid(node.right, upperBound, (long) node.val) && isValid(node.left, (long) node.val, lowerBound);
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = BinaryTreeNode.builder().val(2147483647)
                .left(BinaryTreeNode.builder().val(1).build())
                .right(BinaryTreeNode.builder().val(4)
                        .right(BinaryTreeNode.builder().val(6).build())
                        .left(BinaryTreeNode.builder().val(3).build())
                        .build())
                .build();
        System.out.println(isValidBST(binaryTreeNode));
        Integer x=2147483647;
        System.out.println(x);
    }
}
