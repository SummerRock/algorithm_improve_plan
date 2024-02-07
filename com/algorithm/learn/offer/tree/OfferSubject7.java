package com.algorithm.learn.offer.tree;

import com.algorithm.learn.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class OfferSubject7 {

    /**
     * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
     *
     * @param args
     */
    public static void main(String... args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Root value: " + root.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = indexMap.get(rootVal);
        int leftTreeSize = rootIndex - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, rootIndex - 1, indexMap);
        root.right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd, indexMap);

        return root;
    }
}
