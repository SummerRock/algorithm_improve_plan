package com.algorithm.learn.offer;

public class OfferSubject4 {

    /**
     * 二维数组中的查找
     * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
     *
     * @param args
     */
    public static void main(String... args) {
        int[][] givenArray = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}
        };
        boolean result = find(17, givenArray);
        System.out.println(result);
    }

    public static boolean find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }

    public static boolean findValue(int value, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j > 0; j--) {
                if (arr[i][j] == value) {
                    return true;
                } else if (value < arr[i][j]) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
