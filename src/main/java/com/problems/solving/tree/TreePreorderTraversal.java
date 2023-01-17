package com.problems.solving.tree;

import java.util.ArrayList;
import java.util.List;

public class TreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        travers(root,result);
        return result;

    }

    public void travers(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (Node child : node.children) {
            travers(child, result);
        }
    }
}
