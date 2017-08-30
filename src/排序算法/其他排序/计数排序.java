package 排序算法.其他排序;

/**
 * 计数排序
 * Created by liyanzhen on 17/5/9.
 */
public class 计数排序 {
    public static void main(String args[]) {
        int[] arr = {1, 4, 5, 6, 7, 4, 3, 6, 6, 3, 3, 2};
        Sort(arr);
    }

    public static void Sort(int[] arr) {
        if (arr == null)
            return;
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ++temp[arr[i]];
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (temp[i] == 0)
                continue;
            for (int j = temp[i]; j > 0 && index < arr.length; j--) {
                arr[index++] = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
