package 异常;

/**
 * Created by liyanzhen on 17/7/16.
 */
class SelfException extends RuntimeException {
    SelfException() {
    }

    SelfException(String msg) {
        super(msg);
    }
}

public class TestException5 {
    public static void main(String[] args) {
        firstMethod();
    }

    public static void firstMethod() {
        secondMethod();
    }

    public static void secondMethod() {
        thirdMethod();
    }

    public static void thirdMethod() {
        throw new SelfException("自定义异常信息");
    }
}
