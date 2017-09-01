package 排列组合.组合;

public class 输出数组的所有组合不可重复取 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        combine(arr);
    }

    public static void combine(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] brr = new int[arr.length];
        getCombination(arr, brr, 0, 0);
    }

    /**
     * @param arr   原数组
     * @param brr   缓存数组
     * @param begin 当前起始位置
     * @param index 当前索引
     */
    private static void getCombination(int[] arr, int[] brr, int begin, int index) {
        if (index >= arr.length) {
            return;
        }

        for (int i = begin; i < arr.length; i++) {
            brr[index] = arr[i];
            printArray(brr, index);
            getCombination(arr, brr, i + 1, index + 1);
        }
    }

    private static void printArray(int[] b, int index) {
        for (int i = 0; i < index + 1; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
