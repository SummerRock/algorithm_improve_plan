package com.algorithm.learn.offer;

import java.util.ArrayList;

public class OfferSubject59 {

    /**
     * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
     * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * <p>
     * 窗口大于数组长度或窗口长度为0的时候，返回空。
     *
     * @param args
     */
    public static void main(String... args) {

    }


    /**
     * 暴力解法
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length < 1 || num.length < size) {
            return null;
        }
        for (int i = 0; i < num.length - size + 1; i++) {
            int j = i + size - 1;
            int maxValue = num[j];
            for (int k = i; k < j; ++k) {
                maxValue = Math.max(maxValue, num[k]);
            }
            result.add(maxValue);
        }
        return result;
    }

}
