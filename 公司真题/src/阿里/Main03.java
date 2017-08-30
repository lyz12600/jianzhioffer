package 阿里;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main03 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static int leastBricks(List<List<Integer>> wall) {
        //行数
        int lineCount = wall.size();
        //每一行最近的位置
        int[] pos = new int[lineCount];
        Arrays.fill(pos, 1);
        //每一行当前的长度
        int[] sum = new int[lineCount];
        for (int i = 0; i < lineCount; i++) {
            List<Integer> l = wall.get(i);
            sum[i] += l.get(0);
        }
        int stopPos = Integer.MIN_VALUE;
        for (int i = 0; i < wall.size(); i++) {
            stopPos = Math.max(wall.get(i).size(), stopPos);
        }
        int res = Integer.MAX_VALUE;
        while (stopPos-- > 0) {
            int minPos = getMinPos(sum);
            int minSum = sum[minPos];
            int tempRes = 0;
            for (int i = 0; i < lineCount; i++) {
                //当前行的砖头
                List<Integer> l = wall.get(i);
                if (sum[i] != minSum) {
                    tempRes++;
                } else if (sum[i] == minSum) {
                    if (pos[i] < l.size()) {
                        sum[i] += l.get(pos[i]);
                        if (pos[i] <= l.size()) {
                            pos[i]++;
                        }
                    }
                }
            }
            res = Math.min(res, tempRes);
        }
        return res;
    }

    private static int getMinPos(int[] sum) {
        int res = 0;
        int min = sum[0];
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] < min) {
                res = i;
                min = sum[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> vecvecRes = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
//        Scanner in = new Scanner(System.in);
        Scanner in = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/公司真题/src/阿里/input.txt");
        int res = -1;
        int row = 0;
        row = Integer.parseInt(in.nextLine().trim());
        int i = 0;
        while (i < row) {
            int a = Integer.parseInt(in.nextLine().trim());
            if (a == 0) {
                vecvecRes.add(list);
                list = new ArrayList<Integer>();
                i++;
            } else {
                list.add(a);
            }
        }
        res = leastBricks(vecvecRes);
        System.out.print(res);
    }

    //从文件读取输入数据
    public static Scanner getScanner(String fileName) {
        try {
            return new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
