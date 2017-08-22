package 剑指offer;

/**
 * 面试题：67
 * 机器人的运动范围
 * Created by liyanzhen on 17/7/14.
 */
public class 机器人的运动范围 {
    public static void main(String[] args) {
        int threshold = 5;
        int rows = 10;
        int cols = 10;
        System.out.println(movingCount(threshold, rows, cols));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold == 0) {
            return -1;
        }
        byte[] visited = new byte[rows * cols];

        int count = movingCount(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public static int movingCount(int threshold, int rows, int cols, int row, int col, byte[] visited) {
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols //边界
                && visited[row * cols + col] == 0 //是否访问过
                && (addSum(row) + addSum(col)) <= threshold) {//是否满足条件
            visited[row * cols + col] = 1;

            count = 1 + movingCount(threshold, rows, cols, row - 1, col, visited)
                    + movingCount(threshold, rows, cols, row, col - 1, visited)
                    + movingCount(threshold, rows, cols, row + 1, col, visited)
                    + movingCount(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    public static int addSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
