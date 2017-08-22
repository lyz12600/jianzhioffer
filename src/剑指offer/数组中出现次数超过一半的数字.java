package 剑指offer;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/5/25.
 * 剑指offer
 * 29题
 * 数组中出现次数超过一半的数字
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] str = scanner.nextLine().trim().split("\\s+");
            int[] arr = new int[str.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(MoreThanHalfNum_Solution(arr));
        }
    }

    /**
     * 方法一：key－value计数
     *
     * @param array
     * @return
     */
    //    public static int MoreThanHalfNum_Solution(int[] array) {
//        if (array == null || array.length < 1) {
//            return 0;
//        }
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            if (map.containsKey(array[i])) {
//                int value = map.get(array[i]);
//                map.put(array[i], ++value);
//                continue;
//            }
//            map.put(array[i], 1);
//        }
//
//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            if ((int) entry.getValue() > (array.length / 2)) {
//                return (int) entry.getKey();
//            }
//        }
//        return 0;
//    }

    /**
     * 方法二：基于快排
     */
//    public static int MoreThanHalfNum_Solution(int[] array) {
//        if (!checkInvalidArray(array))
//            return -1;
//        int middle = array.length >> 1;
//        int low = 0;
//        int high = array.length - 1;
//        int pivot = partition(array, low, high);
//        while (pivot != middle) {
//            if (pivot > middle) {
//                high = pivot - 1;
//                pivot = partition(array, low, high);
//            } else {
//                low = pivot + 1;
//                pivot = partition(array, low, high);
//            }
//        }
//
//        int result = array[middle];
//        if (!checkMoreThanHalf(array, result))
//            return 0;
//        return result;
//    }
    public static boolean checkInvalidArray(int[] arr) {
        if (arr == null || arr.length < 1)
            return false;
        return true;
    }

    public static boolean checkMoreThanHalf(int[] arr, int number) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number)
                times++;
        }

        if (times * 2 <= arr.length)
            return false;
        return true;
    }

//    public static int partition(int[] arr, int low, int high) {
//        if (arr == null || arr.length < 1 || low < 0 || high > arr.length) {
//            throw new IllegalArgumentException("参数有误");
//        }
//        int temp = arr[low];
//        while (low < high) {
//            while (low < high && arr[high] >= temp) high--;
//            arr[low] = arr[high];
//            while (low < high && arr[low] <= temp) low++;
//            arr[high] = arr[low];
//        }
//        arr[low] = temp;
//        return low;
//    }

    //    /**
//     * 方法三：基于数组特点
//     */
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (!checkInvalidArray(array))
            return 0;
        int result = array[0];
        int times = 1;

        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkMoreThanHalf(array, result))
            return 0;
        return result;
    }
}