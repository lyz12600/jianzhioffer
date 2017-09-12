package 搜狗;

import java.util.Scanner;

public class 两个圆圈的最大劣弧 {
    public static double process(double[] nodes) {
        if (nodes == null || nodes.length < 2) {
            return 0.0;
        }
        int indexi = 0;
        int indexj = 1;
        double res = 0.0;

        while (indexj < nodes.length) {
            if (nodes[indexj] - nodes[indexi] <= 180.0) {
                res = Math.max(res, nodes[indexj] - nodes[indexi]);
                indexj++;
            } else {
                res = Math.max(res, 360.0 - (nodes[indexj] - nodes[indexi]));
                indexi++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            double[] nodes = new double[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = Double.parseDouble(sc.nextLine());
            }
            System.out.println(String.format("%.8f", process(nodes)));
        }
    }
}