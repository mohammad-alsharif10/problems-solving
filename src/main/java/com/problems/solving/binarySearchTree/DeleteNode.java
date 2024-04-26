package com.problems.solving.binarySearchTree;

import com.problems.solving.tree.TreeNode;

public class DeleteNode {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
               return attach(root);
            } else if (root.right != null) {
                root = root.right;
            } else if (root.left != null) {
                root = root.left;
            }
            return root;
        }
        TreeNode resultParent = helper(root, null, key);
        TreeNode deleted;
        if (resultParent != null) {
            if (resultParent.right != null && resultParent.right.val == key) {
                deleted = resultParent.right;
            } else {
                deleted = resultParent.left;
            }

            if (deleted.left == null && deleted.right == null) {
                if (deleted.val > resultParent.val) {
                    resultParent.right = null;
                } else {
                    resultParent.left = null;
                }
            } else if (deleted.left != null && deleted.right != null) {
                TreeNode node = attach(deleted);
                if (node.val > resultParent.val) {
                    resultParent.right = (node);
                } else {
                    resultParent.left = (node);
                }
            } else if (deleted.right != null) {
                if (deleted.right.val > resultParent.val) {
                    resultParent.right = (deleted.right);
                } else {
                    resultParent.left = (deleted.right);
                }
            } else if (deleted.left != null) {
                if (deleted.left.val > resultParent.val) {
                    resultParent.right = (deleted.left);
                } else {
                    resultParent.left = (deleted.left);
                }
            }
        }
        return root;
    }

    private static TreeNode attach(TreeNode deleted) {

        TreeNode head = deleted.right;
        TreeNode lastLeft = head.left;
        if (lastLeft == null) {
            head.left = (deleted.left);
        } else {
            while (lastLeft.left != null) {
                lastLeft = lastLeft.left;
            }
            lastLeft.left = (deleted.left);
        }
        return head;
    }

    static TreeNode helper(TreeNode node, TreeNode parent, int key) {
        if (node == null) {
            return null;
        }
        TreeNode result;
        if (node.val == key) {
            result = parent;
            return result;
        } else if (node.val > key) {
            return helper(node.left, node, key);
        } else {
            return helper(node.right, node, key);
        }

    }

    public static void main(String[] args) {
        deleteNode(new TreeNode(50, new TreeNode(30, null, new TreeNode(40, null, null)), new TreeNode(70,new TreeNode(60,null,null),new TreeNode(80,null,null))), 50);
    }
}
