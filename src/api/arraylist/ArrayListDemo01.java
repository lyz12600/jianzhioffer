package api.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanzhen on 17/6/15.
 */
public class ArrayListDemo01 {
    public static void main(String args[]) {
//        List<String> list = new ArrayList<>(Integer.MAX_VALUE - 8);
        List<String> list = new ArrayList<>();
        list.add("000");
        list.add("111");
        list.add("222");
        for (String s : list) {
            list.remove(s);
        }
    }
}
