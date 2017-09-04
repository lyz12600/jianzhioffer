package leetcode;

import java.util.HashMap;

public class Max_points_on_a_line {
    public static void main(String[] args) {
//        Point a = new Point(0, 3);
//        Point b = new Point(1, 2);
//        Point c = new Point(3, 0);
//        Point d = new Point(2, 3);

//        Point a = new Point(0, 0);
//        Point b = new Point(2, 2);
//        Point c = new Point(-1, -1);

//        Point a = new Point(0, 0);
//        Point b = new Point(1, 1);
//        Point c = new Point(-1, 1);

        Point a = new Point(84, 250);
        Point b = new Point(1, 0);
        Point c = new Point(0, -70);
        Point d = new Point(0, -70);
        Point e = new Point(1, -1);
        Point f = new Point(21, 10);
        Point g = new Point(42, 90);
        Point h = new Point(-42, -230);
        Point[] arr = {a, b, c, d, e, f, g, h};
        System.out.println(maxPoints(arr));
    }


    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int kx = 1;//在一条垂直线上
            int kp = 0;//重合的点
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    //两个点重合
                    if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) {
                        kp++;
                    }
                    //两个点的横坐标相等，斜率为1
                    if (points[j].x == points[i].x) {
                        kx++;
                        continue;
                    }
                    double k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
                    if (map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    } else {
                        map.put(k, 2);
                    }
                    result = Math.max(result, map.get(k) + kp);
                }
            }
            result = Math.max(result, kx);
        }
        return result;
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}