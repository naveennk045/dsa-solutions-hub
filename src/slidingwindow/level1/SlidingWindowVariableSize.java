package slidingwindow.twopointers;

public class SlidingWindowVariableSize {

    public static void printAllSubarrays(int[] arr) {
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                // Print subarray from `start` to `end`
                System.out.print("[");
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i]);
                    if (i < end) System.out.print(", ");
                }
                System.out.println("]");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5};
        System.out.println("All Subarrays:");
        printAllSubarrays(arr);
    }
}