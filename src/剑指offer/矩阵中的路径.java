package 剑指offer;

/**
 * 面试题：66
 * 矩阵中的路径
 * Created by liyanzhen on 17/7/14.
 */
public class 矩阵中的路径 {
    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
//        char[] str = {'a', 'b', 'c', 'b'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length < 0 || rows < 1 || cols < 1) {
            return false;
        }

        if (str == null) {
            return true;
        }

        byte[] visited = new byte[rows * cols];
        int pathLength = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                      char[] str, int pathLength, byte[] visited) {
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && //考虑边界
                matrix[row * cols + col] == str[pathLength] &&  //值相等
                visited[row * cols + col] == 0) { //未被访问过
            ++pathLength;
            visited[row * cols + col] = 1;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = 0;
            }
        }
        return hasPath;
    }
}
