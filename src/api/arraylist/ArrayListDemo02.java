package api.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liyanzhen on 17/6/27.
 */
public class ArrayListDemo02 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(7);

        list2.add(1);
        list2.add(4);
        list2.add(6);
        list2.add(8);

        Iterator<Integer> ite1 = list1.iterator();
        Iterator<Integer> ite2 = list2.iterator();
        Integer last = null;
        while (ite1.hasNext() && ite2.hasNext()) {
            Integer tmp = ite1.next();
            if (tmp == ite2.next()) {
                last = tmp;
            }
        }
        System.out.println(last);
    }
}
