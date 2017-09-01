package 排列组合.组合;

public class 输出数组的所有组合可重复取 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        combine(arr);
    }

    public static void combine(int[] a) {
        if (null == a || a.length == 0)
            return;
        int[] b = new int[a.length];
        getCombination(a, b, 0);
    }

    private static void getCombination(int[] a, int b[], int index) {
        if (index >= a.length)
            return;
        for (int i = 0; i < a.length; i++) {
            if (index == 0 || a[i] >= b[index - 1]) {
                b[index] = a[i];
                printArray(b, index);
                getCombination(a, b, index + 1);
            }
        }
    }

    private static void printArray(int[] b, int index) {
        for (int i = 0; i < index + 1; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
