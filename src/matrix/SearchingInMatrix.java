package matrix;

public class SearchingInMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Conceptually consider this as 1 D matrix and apply binary search
        int n = matrix.length, m = matrix[0].length;  // Row length and column length
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;


/*        We have two options linear search or binary search ,
        now we are going to perform binary search because the
        array is sorted
    */
        System.out.println(searchMatrix(matrix, target));


    }
}