package niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanzhen on 17/2/24.
 */
public class NewDemo01 {
    public static void main(String[] args) {
        List Listlist1 = new ArrayList();
        Listlist1.add(0);
        List Listlist2 = Listlist1;
        System.out.println(Listlist1.get(0) instanceof Integer);
        System.out.println(Listlist2.get(0) instanceof Integer);
    }
}
