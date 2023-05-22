package com.algorithm.learn;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 在快速排序算法中，选择一个基准元素（通常是数组中的最后一个元素），通过分区操作将数组分成两部分，其中一部分的所有元素小于基准元素，
     * 另一部分的所有元素大于基准元素。然后对这两部分分别递归地进行快速排序，直到排序完成。
     * <p>
     * 在示例代码中，quickSort()方法是公共的快速排序入口，它会调用私有的quickSort()方法进行实际的排序操作。
     * partition()方法用于分区操作，将数组分成小于等于基准元素和大于基准元素的两部分，并返回基准元素的最终位置。
     * swap()方法用于交换数组中两个元素的位置。
     * <p>
     * 在main()方法中，创建一个测试数组并调用quickSort()方法进行排序，然后输出排序后的数组。
     * <p>
     * 运行该示例代码，输出将是经过快速排序算法排序后的数组。
     *
     * @param args arg
     */
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 8, 3, 7, 4, 2, 6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

