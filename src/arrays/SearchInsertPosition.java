package arrays;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr={1};
        System.out.println(binarySearch(arr,0));


    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

}