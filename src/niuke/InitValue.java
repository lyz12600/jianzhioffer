package niuke;

/**
 * Created by liyanzhen on 16/10/28.
 */
public class InitValue {
    //String str = new String("good");
    String str = "good";
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        InitValue initValue = new InitValue();
        initValue.change(initValue.str, initValue.ch);
        System.out.print(initValue.str + "and");
        System.out.println(initValue.ch);
    }

    public void change(String s, char[] chars) {
        s = s.replace("oo", "aa");
        System.out.println("****" + s);
        chars[0] = 'g';
    }
}
