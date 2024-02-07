package com.algorithm.learn.offer.tree;

public class OfferSubject8 {

    /**
     * 二叉树的下一个结点
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     *
     * @param args
     */
    public static void main(String... args) {
        // 构建一个测试用例
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        TreeNode nextNode = getNext(root.left.right);
        if (nextNode != null) {
            System.out.println("Next node value: " + nextNode.val);
        } else {
            System.out.println("There is no inorder successor for the given node.");
        }
    }

    public static TreeNode getNext(TreeNode pNode) {
        if (pNode.right != null) {
            TreeNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.parent != null) {
                TreeNode parent = pNode.parent;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.parent;
            }
        }
        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent = null; // 指向父结点的指针

        TreeNode(int val) {
            this.val = val;
        }
    }
}
