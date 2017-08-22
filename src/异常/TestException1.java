package 异常;

/**
 * Created by liyanzhen on 17/7/16.
 */
public class TestException1 {
    public static void main(String[] args) {
        int a = 6;
        int b = 0;

//        System.out.println(a / b);
//
        try { // try监控区域
            if (b == 0) // 通过throw语句抛出异常
            System.out.println("a/b的值是：" + a / b);
        } catch (ArithmeticException e) { // catch捕捉异常
            System.out.println("程序出现异常，变量b不能为0。");
        }
        System.out.println("程序正常结束。");
    }
}
