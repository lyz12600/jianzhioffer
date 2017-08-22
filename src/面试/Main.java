package 面试;

/**
 * Created by liyanzhen on 17/6/23.
 */
public class Main {
    public static void main(String[] args) {
        int g1 = 2;
        int g2 = 3;
        int[][] arr = {{1, 2}, {2, 4}, {1, 3}, {4, 3}};
        int n = 4;
        System.out.println(cmp(g1, g2, arr, 4));
    }

    public static int cmp(int g1, int g2, int[][] records, int n) {
        if (records == null || records.length < 1 || g1 == g2 || n < 1)
            return 0;
        int flag = 0;
        int index = findAim(records, flag, g1);
        while (index != -1) {//从左边开始
            int target = records[index][1 - flag];
            index = findAim(records, flag, target);
            if (records[index][1 - flag] == g2) {
                return 1;
            }
        }
        return -1;
    }

    public static int findAim(int[][] arr, int flag, int aim) {
        for (int i = 0; i < arr.length; i++) {
            if (flag == 0 && arr[i][flag] == aim) { //左边
                return i;
            }
            if (flag == 1 && arr[i][flag] == aim) { //右边
                return i;
            }
        }
        return -1;
    }
}
