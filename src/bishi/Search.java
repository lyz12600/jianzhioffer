package bishi;

/**
 * Created by liyanzhen on 17/3/24.
 */
public class Search {
    public static void main(String args[]) {
        int arr[] = {5, 7, 7, 8, 8, 10};
        Search search = new Search();
        int[] res = search.searchRange(arr, 8);
        System.out.println(res[0] + "****" + res[1]);
    }

    public int[] searchRange(int arr[], int target) {
        int res[] = new int[2];
        int start = binarySearch(arr, target);
        if (start == -1) {
            res[0] = res[1] = -1;
            return res;
        }
        int end = start;
        res[0] = start;
        while (arr[start] == target) {
            --start;
        }
        res[0] = start + 1;
        while (arr[end] == target) {
            end++;
        }
        res[1] = end - 1 ;
        return res;
    }

    public int binarySearch(int arr[], int target) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            }
            if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
