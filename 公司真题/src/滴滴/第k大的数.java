package 滴滴;

import 华为.ScannerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 第k小的数
 * Created by liyanzhen on 17/5/25.
 */
public class 第k大的数 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        Scanner in = ScannerHelper.getScanner("./公司真题/src/滴滴/input.txt");
        List<Integer> arr = new ArrayList<>();
        while (in.hasNext()) {
            arr.add(in.nextInt());
        }
        int k = arr.remove(arr.size() - 1);
        System.out.println(kth_elem(arr, 0, arr.size() - 1, k));
        in.close();
    }

    public static int kth_elem(List<Integer> arr, int low, int high, int k) {
        if (arr == null || low < 0 || high > arr.size() - 1 || k <= 0 || k > arr.size()) {
            return -1;
        }

        int pivot = arr.get(low);
        int low_temp = low;
        int high_temp = high;

        while (low < high) {
            while (low < high && arr.get(high) > pivot) high--;
            arr.set(low, arr.get(high));
            while (low < high && arr.get(low) <= pivot) low++;
            arr.set(high, arr.get(low));
        }
        arr.set(low, pivot);

        if (arr.size() - k == low) {
            return arr.get(low);
        } else if (arr.size() - k < low) {
            return kth_elem(arr, low_temp, low - 1, k);
        } else {
            return kth_elem(arr, low + 1, high_temp, k);
        }
    }
}
