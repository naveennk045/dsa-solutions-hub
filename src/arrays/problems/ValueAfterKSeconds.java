package arrays.problems;
//https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/

import java.util.Arrays;

public class ValueAfterKSeconds {
    public static void leftSum(long[] nums){
        long sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
    }
    public static long valueAfterKSeconds(int n, int k) {
        long[] nums = new long[n];
        Arrays.fill(nums, 1);
        for (int i = 0; i < k; i++) {
            leftSum(nums);
        }
        return nums[n - 1];
    }
    public static void fibonacci(int n){
        int pointer1=1;
        int pointer2=1;

        System.out.print(pointer1+" ");
        for (int i = 2; i <=n ; i++) {
            System.out.print(pointer2+" ");

            int sum=pointer1+pointer2;
            pointer1=pointer2;
            pointer2=sum;
        }
    }

    public static void printPyramid(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <n+i ; j++) {
                if(j>=n+1-i && j<=n+i-1){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println(valueAfterKSeconds(5,10));
        fibonacci(10);
        System.out.println();
        printPyramid(10);
    }
}