package JVM.chaptertwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanzhen on 17/1/5.
 * java堆溢出---P51
 * VM Args: -Xms20m
 * -Xmx20m
 * -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String args[]) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int count = 0;
        while (true) {
            System.out.println(++count);
            list.add(new OOMObject());
        }
    }
}
