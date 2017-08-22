package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/5/26.
 */
public class 最小的k个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            scanner.nextLine();
            String[] strings = scanner.nextLine().trim().split("\\s+");
            int[] arr = new int[strings.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            List<Integer> list = GetLeastNumbers_Solution(arr, k);
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < 1 || k > input.length || k < 1)
            return list;
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static int partition(int[] arr, int start, int end) {
        int temp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= temp) end--;
            arr[start] = arr[end];
            while (start < end && arr[start] <= temp) start++;
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

//    public static ArrayListDemo02<Integer> GetLeastNumbers_Solution(int[] input, int k) {
//        ArrayListDemo02<Integer> list = new ArrayListDemo02<>();
//        if (input == null || input.length < 1)
//            return list;
//        return partition(list, input, 0, input.length - 1, k);
//    }
//
//    public static ArrayListDemo02<Integer> partition(ArrayListDemo02<Integer> result, int[] arr, int low, int high, int k) {
//        int temp = arr[low];
//        int low_temp = low;
//        int high_temp = high;
//        while (low < high) {
//            while (low < high && arr[high] >= temp) --high;
//            arr[low] = arr[high];
//            while (low < high && arr[low] <= temp) ++low;
//            arr[high] = arr[low];
//        }
//        arr[low] = temp;
//
//        int m = low - low_temp + 1;
//        ArrayListDemo02<Integer> list;
//        if (m == k) {
//            list = addToArrayList(arr, low_temp, low);
//            result.addAll(list);
//        } else if (m < k) {
//            list = addToArrayList(arr, low_temp, low);
//            result.addAll(list);
//            partition(result, arr, low + 1, high_temp, k - m);
//        } else {
//            partition(result, arr, low_temp, low - 1, k);
//        }
//        return result;
//    }
//
//    public static ArrayListDemo02<Integer> addToArrayList(int[] arr, int start, int end) {
//        ArrayListDemo02<Integer> list = new ArrayListDemo02<>();
//        for (int i = start; i <= end; i++) {
//            list.add(arr[i]);
//        }
//        return list;
//    }
}
