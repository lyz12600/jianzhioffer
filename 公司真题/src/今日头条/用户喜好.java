package 今日头条;

import 阿里.Template;

import java.util.Scanner;

public class 用户喜好 {
    public static void main(String[] args) {
        Scanner sc = Template.getScanner("./公司真题/src/今日头条/input.txt");
//      Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] user = new int[n];
            for(int i = 0; i < n; i++){
                user[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[][] querys = new int[m][3];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < 3; j++){
                    querys[i][j] = sc.nextInt();
                }
            }
            int[] res = helper(user, querys);
            for(int a : res){
                System.out.println(a);
            }
        }
    }

    private static int[] helper(int[] user, int[][] querys){
        int[] res = new int[querys.length];
        for(int i = 0; i < querys.length; i++){
            res[i] = find(user, querys[i][0], querys[i][1], querys[i][2]);
        }
        return res;
    }

    private static int find(int[] user, int l, int r, int k){
        int count = 0;
        for(l--, r--; l <= r; l++){
            if(user[l] == k) count++;
        }
        return count;

    }
}
