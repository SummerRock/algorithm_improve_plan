package com.algorithm.learn.offer.tree;

import com.algorithm.learn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OfferSubject77 {

    /**
     * 按之字形顺序打印二叉树
     * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
     *
     * @param args
     */
    public static void main(String... args) {

        // 构建一个二叉树作为示例
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagTraversal(root);

        // 打印结果
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

    public static List<List<Integer>> zigzagTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverseOrder = false; // 用于判断是否需要逆序输出

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (reverseOrder) {
                    level.add(0, node.val); // 逆序插入
                } else {
                    level.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
            reverseOrder = !reverseOrder; // 切换下一层的顺序
        }

        return result;
    }
}
