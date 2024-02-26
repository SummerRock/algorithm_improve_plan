package com.algorithm.learn.offer;

import com.algorithm.learn.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class OfferSubject32 {

    /**
     * 从上往下打印二叉树
     * 不分行从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     *
     * @param args
     */
    public static void main(String... args) {

    }

    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void traverse(TreeNode root, ArrayList<ArrayList<Integer>> res, int depth) {
        if (root != null) {
            //新的一层
            if (res.size() < depth) {
                ArrayList<Integer> row = new ArrayList<>();
                res.add(row);
                row.add(root.val);
                //读取该层的一维数组，将元素加入末尾
            } else {
                ArrayList<Integer> row = res.get(depth - 1);
                row.add(root.val);
            }
        } else
            return;
        //递归左右时深度记得加1
        traverse(root.left, res, depth + 1);
        traverse(root.right, res, depth + 1);
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        if (root == null)
            //如果是空，则直接返回
            return res;
        //递归层次遍历
        traverse(root, temp, 1);
        //送入一维数组
        for (int i = 0; i < temp.size(); i++)
            for (int j = 0; j < temp.get(i).size(); j++)
                res.add(temp.get(i).get(j));
        return res;
    }

    /**
     * 使用队列
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottomV2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            //如果是空，则直接返回空数组
            return res;
        //队列存储，进行层次遍历
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            res.add(cur.val);
            //若是左右孩子存在，则存入左右孩子作为下一个层次
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
        return res;
    }
}
