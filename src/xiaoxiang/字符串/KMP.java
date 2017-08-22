package xiaoxiang.字符串;

/**
 * 求字符串的子串是否存在
 * Created by liyanzhen on 17/6/27.
 */
public class KMP {
    public static void main(String[] args) {
        char[] a = {'a', 'b', 'a', 'd', 'a', 'b', 'a', 'c', 'a', 'b', 'a', 'b'};
        char[] b = {'a', 'b', 'a', 'b'};
        System.out.println(subString(a, b));
        System.out.println(KMP(a, b));
    }

    /**
     * BF
     * 暴力法求解
     *
     * @param a
     * @param b
     * @return
     */
    public static int subString(char[] a, char[] b) {
        if (a == null || a.length < 1)
            return -1;
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == b.length) {
            return i - j;
        }
        return -1;
    }

    public static int KMP(char[] a, char[] b) {
        if (a == null || b == null)
            return -1;
        int i = 0, j = 0;
        int[] next = getNext2(b);
        while (i < a.length && j < b.length) {
            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (j == -1 || a[i] == b[j]) {
                i++;
                j++;
            } else {
                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                j = next[j];
            }
        }
        if (j == b.length) {
            return i - j;
        }
        return -1;
    }

    /**
     * 求next数组
     *
     * @param b
     * @return
     */
    public static int[] getNext1(char[] b) {
        int len = b.length;
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            if (k == -1 || b[j] == b[k]) {
                ++j;
                ++k;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.print(next[i] + " ");
        }
        System.out.println("");
        return next;
    }

    /**
     * 求优化后的next数组
     *
     * @param b
     * @return
     */
    public static int[] getNext2(char[] b) {
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
        int len = b.length;
        int[] next = new int[len];
        int k = -1;
        int j = 0;
        next[0] = -1; // next数组中next[0]为-1
        while (j < len - 1) {
            if (k == -1 || b[j] == b[k]) {
                k++;
                j++;
                // 修改next数组求法
                if (b[j] != b[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.print(next[i] + " ");
        }
        System.out.println("");
        return next;
    }
}
