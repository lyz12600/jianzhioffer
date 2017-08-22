package 剑指offer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * Created by liyanzhen on 17/5/18.
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> list = printMatrix(arr);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;

        while (row > start * 2 && column > start * 2) {
            list.addAll(printMatrixCircle(matrix, row, column, start));
            start++;
        }
        return list;
    }

    public static ArrayList<Integer> printMatrixCircle(int[][] arr, int row, int column, int start) {
        ArrayList<Integer> list = new ArrayList<>();
        int endX = column - 1 - start;
        int endY = row - 1 - start;

        //从左往右
        for (int i = start; i <= endX; i++) {
            list.add(arr[start][i]);
        }

        //从上往下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(arr[i][endX]);
            }
        }

        //从右往左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(arr[endY][i]);
            }
        }

        //从下往上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                list.add(arr[i][start]);
            }
        }

        return list;
    }
}
