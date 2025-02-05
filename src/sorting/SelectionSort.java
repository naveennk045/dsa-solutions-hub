package sorting;

import java.util.Arrays;
import java.util.Scanner;

import static sorting.Swap.swap;

public class SelectionSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            swap(arr,minIndex,i);
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Length of the array : ");
        int n= scan.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= scan.nextInt();
        }

        System.out.println("Before Sorting : "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("After Sorting : "+ Arrays.toString(arr));
    }
}