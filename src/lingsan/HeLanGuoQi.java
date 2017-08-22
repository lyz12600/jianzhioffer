package lingsan;

/**
 * Created by liyanzhen on 17/3/21.
 */
public class HeLanGuoQi {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 2, 1};
        createGuoQi(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void createGuoQi(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        while (j <= k) {
            switch (arr[j]) {
                case 0:
                    swap(arr, i, j);
                    i++;
                    j++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    swap(arr, j, k);
                    k--;
                    break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
