package 剑指offer;

import java.util.LinkedList;

/**
 * Created by liyanzhen on 17/7/8.
 */
public class 数据流中的中位数 {
    static LinkedList<Integer> list = new LinkedList<>();

    public static void Insert(Integer num) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (num > list.get(i)) {
                list.add(i + 1, num);
                return;
            }
        }
        list.addFirst(num);
    }

    public static Double GetMedian() {
        int size = list.size();
        if (size % 2 == 1) {
            return (double) list.get(size / 2);
        } else {
            return (double) (list.get(size / 2 - 1) + list.get(size / 2)) / 2;
        }
    }

    public static void main(String[] args) {
        Insert(5);
        Insert(3);
        Insert(2);
        Insert(1);
        Insert(4);
        System.out.println(GetMedian());
    }
}
