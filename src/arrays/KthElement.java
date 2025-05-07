package arrays;

public class KthElement {
    public static int kthElement(int[] a, int[] b, int k) {
        int p3 = 0;

        int p1 = 0, p2 = 0;
        int n1 = a.length, n2 = b.length;

        int currentElement;
        while (p1 < n1 && p2 < n2) {
            if (a[p1] < b[p2]) {
                currentElement = a[p1];
                p1++;
            } else {
                currentElement = b[p2];
                p2++;
            }
            if (p3 == k-1) return currentElement;
            p3++;
        }

        while (p1 < n1) {
            currentElement = a[p1++];
            if (p3 == k-1) return currentElement;
            p3++;
        }
        while (p2 < n2) {
            currentElement = b[p2++];
            if (p3 == k-1) return currentElement;
            p3++;
        }

        return -1;


    }

    public static void main(String[] args) {
        int[] arr1={2, 3, 6, 7, 9};
        int[] arr2={1, 4, 8, 10};
        System.out.println(kthElement(arr1,arr2,6));
    }
}