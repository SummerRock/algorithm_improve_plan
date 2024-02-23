package com.algorithm.learn.offer;

import java.util.ArrayList;
import java.util.List;

public class OfferSubject74 {

    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     * 现在把问题交给你,你能不能也很快地找出所有和为S的连续正数序列?
     *
     * @param args
     */
    public static void main(String... args) {
        int target = 100;
        List<List<Integer>> result = findContinuousSequence(target);
        for (List<Integer> sequence : result) {
            System.out.println(sequence);
        }
    }










    /**
     * 这是一个经典的滑动窗口问题。我们可以使用双指针来解决这个问题。定义两个指针 start 和 end 分别表示序列的起始和结束位置，
     * 初始时 start 指向 1，end 指向 2，然后不断调整 start 和 end 的位置来寻找满足条件的序列。
     * <p>
     * 如果从 start 到 end 的序列的和等于目标值 S，则将这个序列加入结果集，并将 end 右移一位；
     * 如果序列的和小于 S，则将 end 右移一位，扩大序列的范围；
     * 如果序列的和大于 S，则将 start 右移一位，缩小序列的范围；
     * 当 start 大于 end 时，表示已经遍历完所有可能的序列，结束循环。
     *
     * @param target
     * @return
     */
    public static List<List<Integer>> findContinuousSequence(int target) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 1;
        int end = 2;
        int sum = start + end;

        while (start < end) {
            if (sum == target) {
                List<Integer> sequence = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    sequence.add(i);
                }
                result.add(sequence);
                sum -= start;
                start++;
            } else if (sum < target) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        return result;
    }
}
