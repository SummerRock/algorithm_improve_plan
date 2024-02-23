package com.algorithm.learn.offer;

import java.util.Arrays;

public class OfferSubject57 {

    /**
     * 输入一个升序数组 array 和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，返回任意一组即可，如果无法找出这样的数字，返回一个空数组即可。
     *
     * @param args
     */
    public static void main(String... args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int[] result = FindNumbersWithSum(array, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] FindNumbersWithSum(int[] array, int sum) {
        int left = 0;
        int right = array.length - 1;
        while (right > left) {
            if (array[left] + array[right] == sum) {
                return new int[]{array[left], array[right]};
            } else if (array[left] + array[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
