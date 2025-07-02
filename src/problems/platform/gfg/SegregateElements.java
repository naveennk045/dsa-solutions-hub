package problems.platform.gfg;

import java.util.Arrays;

public class SegregateElements {
    public static void segregateElements(int[] arr) {

        for (int p1 = 0, p2 = 0; p1 < arr.length; p1++) {
            if (arr[p1] >= 0) {
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
                p2++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 3, 2, -7, -5, 11, 6};
        segregateElements(nums);

        System.out.println(Arrays.toString(nums));
    }
}