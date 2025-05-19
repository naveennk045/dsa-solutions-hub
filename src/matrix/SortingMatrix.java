package matrix;

import sorting.Swap;

import java.util.Arrays;

public class SortingMatrix {

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int start = low;
        int end = high;

        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        while (start <= end) {
            while (start <= end && nums[start] < pivot) start++;
            while (start <= end && nums[end] > pivot) end--;

            if (start <= end) {
                Swap.swap(nums, start, end);
                start++;
                end--;
            }
        }

        quickSort(nums, low, end);
        quickSort(nums, start, high);

    }

    public static void insertionSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[minIdx] > nums[j]) minIdx = j;
            }
            Swap.swap(nums, i, minIdx);
        }
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    isSwapped = true;
                    Swap.swap(nums, j, j + 1);
                }
            }
            if (!isSwapped) break;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {10, 3, 25},
                {7, 15, 1},
                {20, 2, 8}
        };

        for (int[] row : matrix) {
//            bubbleSort(row);
//            selectionSort(row);
//            insertionSort(row);
//            quickSort(row, 0, row.length - 1);
            Arrays.sort(row);
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }


    }
}