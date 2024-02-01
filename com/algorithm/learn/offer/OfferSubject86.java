package com.algorithm.learn.offer;

import com.algorithm.learn.TreeNode;

public class OfferSubject86 {

    /**
     * 在二叉树中找到两个节点的最近公共祖先
     *
     * @param args
     */
    public static void main(String... args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode o1, TreeNode o2) {
        // write code here
        if (root == null || root == o1 || root == o2) {
            return root;
        }
        TreeNode right = lowestCommonAncestor(root.right, o1, o2);
        TreeNode left = lowestCommonAncestor(root.left, o1, o2);
        //如果left为空，说明这两个节点在root结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null) {
            return right;
        }
        // 同上
        if (right == null) {
            return left;
        }
        //如果left和right都不为空，说明这两个节点一个在root的左子树上一个在root的右子树上，
        //我们只需要返回cur结点即可。
        return root;
    }
}
