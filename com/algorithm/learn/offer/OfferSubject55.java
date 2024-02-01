package com.algorithm.learn.offer;

import com.algorithm.learn.TreeNode;

public class OfferSubject55 {

    /**
     * 二叉树的深度
     *
     * @param args
     */
    public static void main(String... args) {

    }

    public static int maxDepth(TreeNode root) {
        //空节点没有深度
        if (root == null)
            return 0;
        //返回子树深度+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
