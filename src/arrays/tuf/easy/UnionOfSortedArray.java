package arrays.tuf.easy;
import java.util.ArrayList;
import java.util.List;

public class UnionOfSortedArray {

    public static List<Integer> findUnion(int[] nums1, int[] nums2){
        ArrayList<Integer> union = new ArrayList<>();

        int p1 = 0, p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                if (union.isEmpty() || union.getLast() != nums1[p1]) {
                    union.add(nums1[p1]);
                }
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                if (union.isEmpty() || union.getLast() != nums2[p2]) {
                    union.add(nums2[p2]);
                }
                p2++;
            } else {
                if (union.isEmpty() || union.getLast() != nums1[p1]) {
                    union.add(nums1[p1]);
                }
                p1++;
                p2++;
            }
        }

        // Add remaining elements of nums1
        while (p1 < nums1.length) {
            if (union.isEmpty() || union.getLast() != nums1[p1]) {
                union.add(nums1[p1]);
            }
            p1++;
        }

        // Add remaining elements of nums2
        while (p2 < nums2.length) {
            if (union.isEmpty() || union.getLast() != nums2[p2]) {
                union.add(nums2[p2]);
            }
            p2++;
        }

        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 5, 6};

        List<Integer> result = findUnion(arr1, arr2);
        System.out.println("Union: " + result);
    }
}