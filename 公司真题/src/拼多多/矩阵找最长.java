package 拼多多;

public class 矩阵找最长 {
    public static void main(String[] args) {
        char[][] chars = {{'X', ' ', ' ', ' ', ' '},
                {'X', 'X', 'X', ' ', 'X'},
                {' ', ' ', 'X', 'X', 'X'}};

        System.out.println(getSum(chars));
    }

    public static int getSum(char[][] chars) {
        if (chars == null || chars.length < 1) {
            return -1;
        }
        byte[] visited = new byte[chars.length * chars[0].length];
        int count = movingCount(chars, chars.length, chars[0].length, 0, 0, visited);
        return count;
    }

    public static int movingCount(char[][] chars, int rows, int cols, int row, int col, byte[] visited) {
        int count = 0;
        if (move(chars, rows, cols, row, col, visited)) {//是否满足条件
            count = 1 + movingCount(chars, rows, cols, row - 1, col, visited)
                    + movingCount(chars, rows, cols, row, col - 1, visited)
                    + movingCount(chars, rows, cols, row + 1, col, visited)
                    + movingCount(chars, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    public static boolean move(char[][] chars, int rows, int cols, int row, int col, byte[] visited) {
        if (row >= 0 && row < rows
                && col >= 0 && col < cols //边界
                && visited[row * cols + col] == 0
                && chars[row][col] != ' ') {//是否访问过
            visited[row * cols + col] = 1;
            return true;
        }
        return false;
    }

}
