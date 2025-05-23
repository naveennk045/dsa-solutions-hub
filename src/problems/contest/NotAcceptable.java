package problems.contest;

import java.util.Scanner;

public class NotAcceptable {
    public static boolean isAcceptable(int[] timings) {
        return timings[0] > timings[2] || timings[0] == timings[2] && timings[1] > timings[3];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] timings = new int[4];

        for (int i = 0; i < 4; i++) {
            timings[i] = scan.nextInt();
        }
        if (isAcceptable(timings)) System.out.println("Yes");
        else System.out.println("No");
    }
}