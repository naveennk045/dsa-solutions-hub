package recursion;

import sorting.Swap;

import java.util.Arrays;

public class SortRecursion {
    public static void selectionSort(int[] nums, int i, int j, int minIdx) {
        if (i == nums.length) return;

        if (j < nums.length) {
            if (nums[minIdx] > nums[j]) {
                minIdx = j;
            }
            selectionSort(nums, i, j + 1, minIdx);
        } else {
            Swap.swap(nums, i, minIdx);
            selectionSort(nums, i + 1, i + 2, i + 1);
        }
    }

    public static void bubbleSort(int[] nums, int n, int i) {
        if (n == 0) return;

        if (i < n) {
            if (nums[i] > nums[i + 1]) {
                Swap.swap(nums, i, i + 1);
            }
            bubbleSort(nums, n, i + 1);
        } else {
            bubbleSort(nums, n - 1, 0);
        }


    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 6, 5};
        bubbleSort(nums, nums.length - 1, 0);
        selectionSort(nums, 0, 0, 0);
        System.out.println(Arrays.toString(nums));

    }
}