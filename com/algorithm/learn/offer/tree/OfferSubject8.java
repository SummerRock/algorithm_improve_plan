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



    /**
     * 如果当前节点有右子树，则中序遍历的下一个节点是右子树的最左边的节点。
     * 如果当前节点没有右子树，并且它是父节点的左子节点，则下一个节点是它的父节点。
     * 如果当前节点没有右子树，并且它是父节点的右子节点，则需要沿着父节点的指针向上遍历，直到找到一个节点是其父节点的左子节点，该父节点就是下一个中序遍历的节点。
     * @param pNode
     * @return
     */
    public static TreeNode getNext(TreeNode pNode) {
        // 如果有右子树，则下一个节点是右子树的最左边的节点
        if (pNode.right != null) {
            TreeNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            // 如果当前节点是父节点的右子节点，沿着父节点向上遍历，直到找到一个节点是其父节点的左子节点
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
