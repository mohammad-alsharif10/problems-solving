package com.problems.solving.tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;


    }

    public static String print(String firstName,
                               String invoiceNumber,
                               String unitNumber,
                               String projectName,
                               Integer paymentAmount,
                               String whatsappUrl) {
        return String.format("حياك الله %s \n\n تم إصدار فاتورة برقم %s \n عربون حجز وحدة %s في مشروع %s بمبلغ قدره %s ريال سعودي \n\n سيتم التواصل معكم لاستكمال بقية الإجراءات,ويمكنك التواصل مع فريق رواف عند وجود أي استفسار \n %s \n منصة رواف العقارية",
                firstName,
                invoiceNumber,
                unitNumber,
                projectName,
                paymentAmount,
                whatsappUrl);    }

    public static void main(String[] args) {
        System.out.println(print("mohammad", "12343", "333", "project", 1, "whatsApp"));
    }
}
