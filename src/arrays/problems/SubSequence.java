package arrays.problems;

import java.util.Scanner;

public class SubSequence {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int[] nums={1,2,3};

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j]+" ");
            }
            System.out.println();
        }
    }
}