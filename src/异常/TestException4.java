package 异常;

/**
 * Created by liyanzhen on 17/7/16.
 */
public class TestException4 {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a / b;
            System.out.println("您输入的两个数相除的结果是：" + c);
        } catch (IndexOutOfBoundsException | NumberFormatException | ArithmeticException ie) {
            System.out.println("程序发生了数组越界、数字格式异常、算术异常之一");
            ie.printStackTrace();
//            System.out.println(ie.getClass());
        } catch (Exception e) {
            System.out.println("未知异常");
        }
    }
}
