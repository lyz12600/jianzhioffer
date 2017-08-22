package 剑指offer;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/6/4.
 * 输入：7 5 6 4
 * 输出：5
 */
public class 数组的逆序对 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] str = s.nextLine().trim().split("\\s+");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(InversePairs(arr));
        }
    }

    public static int InversePairs(int[] array) {
        if (array == null || array.length < 1)
            return 0;

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count % 1000000007;
    }

    private static int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = InversePairsCore(copy, array, start, start + length) % 1000000007;
        int right = InversePairsCore(copy, array, start + length + 1, end) % 1000000007;
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - length;
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        for (; i >= start; i--)
            copy[indexCopy--] = array[i];
        for (; j >= start + length + 1; j--)
            copy[indexCopy--] = array[j];

        return left + right + count;
    }
}
