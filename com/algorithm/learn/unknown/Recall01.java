package com.algorithm.learn.unknown;

import java.util.ArrayList;
import java.util.List;

public class Recall01 {

    /**
     * 一个无序，不重复数组，输出N个元素，使得N个元素的和相加为M
     *
     * @param args
     */
    public static void main(String... args) {
        int[] nums = {2, 3, 4, 5, 6, 7};
        int N = 3;
        int M = 15;

        List<List<Integer>> result = combinationSum(nums, N, M);
        System.out.println("Result: " + result);
    }


    /**
     * 要从无序不重复的数组中找出 N 个元素，使它们的和为 M，可以使用回溯法来解决。回溯法是一种通过不断地尝试可能的解，并在不符合条件时进行回溯的方法。
     * 通过回溯法，可以找出数组中所有和为 M 的 N 个元素的组合。
     *
     * @param nums 无序不重复的数组
     * @param N    表示要找出的元素个数
     * @param M    表示元素的和
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] nums, int N, int M) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, nums, N, M, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int N, int M, int start) {
        if (N == 0 && M == 0) { // 如果 N 和 M 都为 0，说明找到了符合条件的组合，将当前组合加入结果列表中。
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= M) {
                current.add(nums[i]);
                // 遍历数组中的每个元素，将其加入当前组合中，并递归调用 backtrack 方法查找剩余元素的组合。
                backtrack(result, current, nums, N - 1, M - nums[i], i + 1);
                // 在递归调用完成后，将当前元素从当前组合中移除，继续遍历下一个元素
                current.remove(current.size() - 1);
                // 为什么需要移除？
                // 在递归调用中，我们需要保证每次递归调用的状态是独立的，即每次递归调用都是在当前状态的基础上进行操作，并且不会影响到其他递归调用的状态。
                // 因此，在每次递归调用完成后，我们需要将当前操作添加的元素从当前组合中移除，以保证下一次递归调用时不受上一次调用的影响。
                // 具体来说，在回溯法中，我们需要探索所有可能的组合，而每个组合都是由一系列操作构建而成的。
                // 如果我们在递归调用完成后不将当前操作添加的元素移除，那么这些元素将会影响到后续的递归调用，导致得到错误的结果。
                // 因此，为了保证递归调用的独立性和正确性，我们需要在递归调用完成后将当前操作添加的元素从当前组合中移除，以便下一次递归调用可以在独立的状态下进行操作。
            }
        }
    }
}
