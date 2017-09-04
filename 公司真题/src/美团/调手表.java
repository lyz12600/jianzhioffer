package 美团;

import java.util.Scanner;

public class 调手表 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int start = s.nextInt();
            int target = s.nextInt();
            System.out.println(solution(start, target));
        }
    }

    public static int solution(int start, int target) {
        if (start == target) {
            return 0;
        }
        int temp_1 = (target - start + 360) % 360;
        int temp_2 = (start - target + 360) % 360;
        return temp_1 < temp_2 ? temp_1 : -temp_2;
    }
}
