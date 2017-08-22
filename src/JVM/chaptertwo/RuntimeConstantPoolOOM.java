package JVM.chaptertwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanzhen on 17/1/7.
 * 本机jdk1.8 无法溢出
 * 运行时常量池导致的内存溢出---P56
 * VM Args:
 * -XX:PermSize=10M
 * -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {
    public static void main(String args[]){
        List<String> list = new ArrayList<String>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
