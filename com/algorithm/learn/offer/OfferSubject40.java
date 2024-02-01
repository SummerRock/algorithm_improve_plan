package com.algorithm.learn.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class OfferSubject40 {

    /**
     * 最小的K个数
     *
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
