package JVM.chaptertwo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by liyanzhen on 17/1/8.
 * -Xmx20M
 * -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1M = 1024 * 1024;

    public static void main(String args[]) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1M);
        }
    }
}
