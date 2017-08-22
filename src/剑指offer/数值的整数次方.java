package 剑指offer;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 数值的整数次方
 * Created by liyanzhen on 17/5/13.
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double base = scanner.nextDouble();
            int exponent = scanner.nextInt();
            System.out.println(power(base, exponent));
        }
    }

    public static double power(double base, int exponent) {//判断特殊情况
        if (exponent == 0) {
            return 1;
        }
        if (equal(base, 0.00)) {
            return 0;
        }
        double sum = 0;
        if (exponent > 0) {//指数为正数时
            sum = calculate(base, exponent);
        } else if (exponent < 0) { //指数为负数时
            sum = 1 / calculate(base, -exponent);
            DecimalFormat df = new DecimalFormat("###.000");
            sum = Double.parseDouble(df.format(sum));
        }
        return sum;
    }

    public static double calculate(double base, int exponent) { //计算连乘
        double sum;
//        double sum = base;
//        exponent--;
//        while (exponent != 0) {
//            sum = sum * base;
//            exponent--;
//        }
        //优化
        if (exponent == 1) {
            return base;
        }

        sum = calculate(base, exponent >> 1);
        sum = sum * sum;
        if ((exponent & 0x1) == 1) {
            sum = sum * base;
        }

        //格式转换
        DecimalFormat df = new DecimalFormat("###.000");
        sum = Double.parseDouble(df.format(sum));
        return sum;
    }

    public static boolean equal(double a, double b) {//判断两个double类型的数是不是相等时，不能用==
        if (((a - b) < 0.0000001) && (b - a) < 0.0000001) {
            return true;
        }
        return false;
    }
}
