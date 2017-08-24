package 华为;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by liyanzhen on 17/6/28.
 */
public class 字符串运算 {

    private static final int REVERSE = 1;
    private static final int SEARCH = 2;
    private static final int COMBINE = 3;
    private static final int QUOTE = 4;

    public static void main(String[] args) {
//        Scanner in = getScanner(System.in);
        Scanner in = getScanner("腾讯/input.txt");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            stack.clear();
            sb.setLength(0);
            String line = in.nextLine();
            //运算符和参数
            List<String> expression = new ArrayList<>();
            boolean hasLeft = false;
            boolean hasRightQuote = true;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(' && hasRightQuote) {
                    hasLeft = true;
                    stack.push("(");
                    //计算括号值
                } else if (line.charAt(i) == ')' && hasRightQuote && hasLeft) {
                    expression.clear();
                    while (!stack.peek().equals("(")) {
                        expression.add(stack.pop());
                    }
                    //弄出左括号
                    stack.pop();
                    Collections.reverse(expression);
                    //将括号内表达式的值入栈顶
                    stack.push(operator(expression));
                } else if (line.charAt(i) == ' ') {
                    if (hasRightQuote) {
                        if (sb.length() > 0) {
                            stack.push(sb.toString());
                            sb.setLength(0);
                        }
                    } else {
                        sb.append(' ');
                    }

                } else if (line.charAt(i) == '"') {
                    if (!hasRightQuote) {
                        if (sb.length() > 0) {
                            stack.push(sb.toString());
                            sb.setLength(0);
                        }
                    }
                    hasRightQuote = !hasRightQuote;
                } else {
                    sb.append(line.charAt(i));
                }
            }
            System.out.printf("\"%s\"\n", stack.pop());
        }
    }

    private static String operator(List<String> expression) {
        int type = getOperate(expression.get(0));
        switch (type) {
            case QUOTE:
                return quote(expression.get(1));
            case REVERSE:
                StringBuilder sb = new StringBuilder();
                expression.remove(0);
                for (int i = 0; i < expression.size(); i++) {
                    sb.append(expression.get(i));
                    if (i < expression.size() - 1) {
                        sb.append(" ");
                    }
                }
                return reverse(sb.toString());
            case SEARCH:
                return search(expression.get(1), expression.get(2));
            case COMBINE:
                expression.remove(0);
                String[] strs = new String[expression.size()];
                int i = 0;
                for (String s : expression) {
                    strs[i++] = s;
                }
                return combine(strs);
        }
        return "";
    }

    //从输入流读取输入数据
    public static Scanner getScanner(InputStream is) {
        return new Scanner(is);
    }

    //从文件读取输入数据
    public static Scanner getScanner(String fileName) {
        try {
            return getScanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int getOperate(String operator) {
        switch (operator) {
            case "reverse":
                return REVERSE;
            case "search":
                return SEARCH;
            case "combine":
                return COMBINE;
            case "quote":
                return QUOTE;
        }
        return -1;
    }

    private static String quote(String s) {
        return s;
    }

    private static String reverse(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    private static String search(String s1, String s2) {
        int pos = s1.indexOf(s2);
        if (pos == -1) {
            return "";
        }
        return s1.substring(pos);
    }

    private static String combine(String... value) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
        }
        return sb.toString();
    }
}
