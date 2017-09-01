package 排列组合.组合;

/**
 * a={1,2,3}。当n=2时候的所有组合数为12，13，23
 */
public class 取出n个数的所有组合不可重复取 {
    public static void main(String[] args) {
        取出n个数的所有组合不可重复取 test = new 取出n个数的所有组合不可重复取();
        int[] a = {1, 2, 3};
        int n = 2;
        test.combine(a, n);
    }

    public void combine(int[] a, int n) {
        if (null == a || a.length == 0 || n <= 0 || n > a.length) {
            return;
        }
        int[] b = new int[n];//辅助空间，保存待输出组合数
        getCombination(a, n, 0, b, 0);
    }

    public void getCombination(int[] a, int n, int begin, int[] b, int index) {
        if (n == 0) {//如果够n个数了，输出b数组
            for (int i = 0; i < index; i++) {
                System.out.print(b[i]);
            }
            System.out.println();
            return;
        }

        for (int i = begin; i < a.length; i++) {
            b[index] = a[i];
            getCombination(a, n - 1, i + 1, b, index + 1);
        }
    }
}
