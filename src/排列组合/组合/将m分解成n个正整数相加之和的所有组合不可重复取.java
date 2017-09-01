package 排列组合.组合;

public class 将m分解成n个正整数相加之和的所有组合不可重复取 {
    public static void main(String[] args) {
        combine(6, 3);
    }

    public static void combine(int m, int n) {
        if (m < 1 || n < 1)
            return;

        int[] b = new int[n];
        getCombination(m, n, b, 0, 1);
    }

    private static void getCombination(int m, int n, int b[], int index, int begin) {
        if (n == 0 && m == 0) {
            for (int i = 0; i < b.length; i++)
                System.out.print(b[i] + " ");
            System.out.println();
        }
        if (n == 0)
            return;

        for (int i = begin; i <= m; i++) {
            b[index] = i;
            getCombination(m - i, n - 1, b, index + 1, i + 1);
        }
    }
}
