package com.algorithm.learn.offer;

import java.util.ArrayList;

public class OfferSubject29 {

    /**
     * 顺时针打印矩阵
     * 按顺时针的方向，从外到里打印矩阵的值。
     *
     * @param args
     */
    public static void main(String... args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        ArrayList<Integer> result = printMatrix(matrix);
        System.out.println(result.toString());
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int curCol = 0;
        int curRow = 0;
        int colLength = matrix[0].length - 1;
        int rowLength = matrix.length - 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (curRow <= rowLength && curCol <= colLength) {
            // 上
            for (int i = curCol; i <= colLength; i++) {
                arrayList.add(matrix[curRow][i]);
            }
            // 右
            for (int i = curRow + 1; i <= rowLength; i++) {
                arrayList.add(matrix[i][rowLength]);
            }
            if (curRow != rowLength) {
                // 下
                for (int i = rowLength - 1; i >= curCol; i--) {
                    arrayList.add(matrix[rowLength][i]);
                }
            }
            if (curCol != colLength) {
                // 上
                for (int i = rowLength - 1; i > curRow; i--) {
                    arrayList.add(matrix[i][curCol]);
                }
            }
            curRow++;
            rowLength--;
            curCol++;
            colLength--;
        }
        return arrayList;
    }
}
