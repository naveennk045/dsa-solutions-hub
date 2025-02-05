package arrays;


import java.util.Arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        int index = findIndex(arr);
        System.out.println("Index: " + index);

        if (index == -1) {
            reverseArray(arr, 0);
        } else {
            swap(arr, index);
            reverseArray(arr, index + 1);
        }

        System.out.println(Arrays.toString(arr));
    }

    static int findIndex(int[] arr) {
        // Find the largest index such that arr[i] < arr[i + 1]
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                return i - 1;
            }
        }
        // If no such index exists, return -1
        return -1;
    }

    static void swap(int[] arr,int ind){
        for (int j = arr.length-1 ;j> ind ; j--) {
            if(arr[j]>arr[ind]){
                int temp=arr[ind];
                arr[ind]=arr[j];
                arr[j]=temp;
                break;
            }
        }
    }

    static void reverseArray(int arr[],int ind){
        int s= ind;
        int e= arr.length-1;
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;

        }
    }

}