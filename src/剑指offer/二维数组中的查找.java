package 剑指offer;

/**
 * Created by liyanzhen on 17/3/9.
 * 二维数组中的查找
 * 输入输出：
 * 5 5 43
 * 1   2   3   4   5
 * 6   7   8   9   10
 * 11  12  13  14  15
 * 16  17  18  19  20
 * 21  22  23  24  25
 */

import java.util.Scanner;

import static aaa.Template.getScanner;


public class 二维数组中的查找 {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
        Scanner s = getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/aaa/input.txt");
        while (s.hasNextInt()) {
            int i = s.nextInt();
            int j = s.nextInt();
            int target = s.nextInt();
            int[][] arr = new int[i][j];
            for (int k = 0; k < i; k++) {
                for (int l = 0; l < j; l++) {
                    arr[k][l] = s.nextInt();
                }
            }
            System.out.println(Find(target, arr));
        }
    }

    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length < 1) {
            return false;
        }

        int i = 0;
        int j = array[0].length - 1;//从右上开始
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
