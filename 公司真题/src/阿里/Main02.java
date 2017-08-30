package 阿里;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int lineCount = Integer.parseInt(in.nextLine());
            int peopleCount = Integer.parseInt(in.nextLine());
            int[][] numbers = new int[lineCount][lineCount];
            for (int i = 0; i < lineCount; i++) {
                String line = in.nextLine();
                String[] number = line.split(",");
                for (int j = 0; j < peopleCount; j++) {
                    numbers[i][j] = Integer.parseInt(number[j]);
                }
            }
            System.out.println(solve(numbers));
        }
        in.close();
    }

    static class Node {
        int parent;

        Node(int parent) {
            this.parent = parent;
        }
    }

    private static int solve(int[][] numbers) {
        int peopleCount = numbers[0].length;
        Node[] nodes = new Node[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < peopleCount; j++) {
                if (numbers[i][j] == 1) {
                    if (nodes[i].parent < nodes[j].parent) {
                        nodes[j].parent = nodes[i].parent;
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nodes.length; i++) {
            set.add(nodes[i].parent);
        }
        return set.size();
    }
}


