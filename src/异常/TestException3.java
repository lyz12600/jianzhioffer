package 异常;

import java.io.IOException;

/**
 * Created by liyanzhen on 17/7/16.
 */
public class TestException3 {
    static void pop() throws IOException {
        // 定义方法并抛出NegativeArraySizeException异常
        int[] arr = new int[-3]; // 创建数组
    }

    public static void main(String[] args) { // 主方法
//        pop(); // 调用pop()方法
    }
}
