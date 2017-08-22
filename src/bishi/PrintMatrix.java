package bishi;

/**
 * Created by liyanzhen on 17/3/28.
 */
public class PrintMatrix {
    public static void main(String[] args) {
        PrintMatrix p = new PrintMatrix();
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        p.print_rotate_matrix(arr, 4);
    }

    public void print_rotate_matrix(int[][] matrix, int n) {
        //输出右上角
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matrix[j][n + j - 1 - i] + " ");
            }
            System.out.println(" ");
        }

        //输出左下角
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print(matrix[i + j][j] + " ");
            }
            System.out.println(" ");
        }


//        for (int i = n - 2; i >= 0; i--) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(matrix[j + n - i - 1][j] + " ");
//            }
//            System.out.println(" ");
//        }
    }
}
