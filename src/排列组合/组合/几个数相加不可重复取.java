package 排列组合.组合;

/**
 * 输入两个整数n和m，从数列1，2，3.......n中随意取几个数，使其和等于m,
 * 要求将其中所有的可能组合列出来（不可重复取）
 * 如输入：
 * m = 5,n = 10,
 * 输出：
 * 1 4
 * 2 3
 */
public class 几个数相加不可重复取 {
    public static void main(String[] args) {
        几个数相加不可重复取 test = new 几个数相加不可重复取();
        test.combine(10, 12);
    }

    public static void combine(int m, int n) {

        if (m < 1 || n < 1)
            return;

        if (n > m)//如果n>m,把n>m的数去掉
            n = m;

        boolean[] b = new boolean[n + 1];//保存是否装包
        getCombination(m, n, b);
    }

    public static void getCombination(int m, int n, boolean[] b) {

        if (m < 1 || n < 1)//递归出口
            return;

        if (m == n) {//输出组合
            b[n] = true;
            for (int i = 1; i < b.length; i++) {
                if (b[i] == true)
                    System.out.print(i + " ");

            }
            System.out.println();
            b[n] = false;
        }
        b[n] = true;//装包
        getCombination(m - n, n - 1, b);
        b[n] = false;//不装包
        getCombination(m, n - 1, b);
    }
}
