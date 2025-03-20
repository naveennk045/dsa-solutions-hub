package sandbox;

public class TwoSumSorted {
    public static int[] findPair(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                return new int[]{arr[left], arr[right]}; // Found the pair
            } else if (currentSum < target) {
                left++; // Move left pointer to increase sum
            } else {
                right--; // Move right pointer to decrease sum
            }
        }
        return null; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8, 9}; // Sorted array
        int target = 10;

        int[] result = findPair(arr, target);
        if (result != null) {
            System.out.println("Pair found: (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("No pair found.");
        }
    }
}