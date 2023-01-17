package com.problems.solving.binarySearchTree;

public class LowestCommonAncestor {
    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        BinaryTreeNode cur= root;
        while (cur!=null){
            if (p.val> cur.val&&q.val>cur.val){
                cur=cur.right;
            }else if (p.val< cur.val&&q.val<cur.val){
                cur=cur.left;
            }else {
                return cur;
            }
        }
        return cur;
    }

}
