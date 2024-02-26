package com.algorithm.learn.offer;

import com.algorithm.learn.TreeNode;

public class OfferSubject54 {

    /**
     * 二叉搜索树的第k个节点
     * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。
     * 1.返回第k小的节点值即可
     * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
     * 3.保证n个节点的值不一样
     *
     * @param args
     */
    public static void main(String... args) {

    }

    //记录返回的节点
    private static TreeNode res = null;
    //记录中序遍历了多少个
    private static int count = 0;

    public static void minOrder(TreeNode proot, int k) {
        // write code here
        //当遍历到节点为空或者超过k时，返回
        if (proot == null || count > k) {
            return;
        }
        minOrder(proot.left, k);
        count++;
        //只记录第k个
        if (count == k) {
            res = proot;
        }
        minOrder(proot.right, k);
    }

    public static int KthNode(TreeNode proot, int k) {
        minOrder(proot, k);
        if (res != null) {
            return res.val;
        } else {
            return -1;
        }
    }
}
