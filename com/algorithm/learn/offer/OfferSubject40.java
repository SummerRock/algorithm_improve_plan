package com.algorithm.learn.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class OfferSubject40 {

    /**
     * 最小的K个数
     * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
     * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
     * @param args
     */
    public static void main(String... args) {
        int[] ints = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = GetLeastNumbers_Solution(ints, 4);
        System.out.println(result.toString());
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
