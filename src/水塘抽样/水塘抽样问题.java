package 水塘抽样;

import java.util.Random;

public class 水塘抽样问题 {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        shuffleArray(arr);
    }

    private static void shuffleArray(int[] arr) {
        Random random = new Random();
        int temp;
        int r;
        for (int i = arr.length; i > 1; i--) {
            r = random.nextInt(i);
            temp = arr[i - 1];
            arr[i - 1] = arr[r];
            arr[r] = temp;
            System.out.println(arr[i - 1]);
        }
    }
}
