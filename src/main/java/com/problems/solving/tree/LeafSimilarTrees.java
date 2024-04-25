package com.problems.solving.tree;

public class LeafSimilarTrees {

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        String firstSeq = getSeq(root1);
        String secondSeq = getSeq(root2);
        return firstSeq.equals(secondSeq);
    }

    static String getSeq(TreeNode root) {
        String firstSeq = "";
        if (root == null) {
            return firstSeq;
        }
        if (root.left == null && root.right == null) {
            return root.val +"-";
        }
        firstSeq = firstSeq + getSeq(root.left);
        firstSeq = firstSeq + getSeq(root.right);
        return firstSeq;
    }

    public static void main(String[] args) {
        leafSimilar(TreeNode.builder().val(1).left(TreeNode.builder().val(2).build()).right(TreeNode.builder().val(3).build()).build(),
                TreeNode.builder().val(1).left(TreeNode.builder().val(3).build()).right(TreeNode.builder().val(2).build()).build());
    }
}
