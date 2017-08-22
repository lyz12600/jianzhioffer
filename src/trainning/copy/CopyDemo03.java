package trainning.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanzhen on 17/4/24.
 */
public class CopyDemo03 {
    public static void main(String[] args) {
//        List<String> list = new ArrayListDemo02<>();
//        list.add("lyz");
//        List<String> l = list;
//        l.add("zzj");

        List<String> list = new ArrayList<>();
        list.add("lyz");
        List<String> l = new ArrayList<>(list);
        l.add("zzj");


        System.out.println(list.hashCode());
        System.out.println(l.hashCode());
        for (String s : list) {
            System.out.print(s + "  ");
        }
        System.out.println("");
        for (String s : l) {
            System.out.print(s + "  ");
        }
    }
}
