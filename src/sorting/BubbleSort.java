package sorting;

import java.util.Arrays;
import java.util.Scanner;
import static sorting.Swap.swap;

public class BubbleSort {
    public  static void sort(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
//    optimized approach
    public static void optimizedSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean isSwapped=false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    isSwapped=true;
                }
            }
            if (!isSwapped) break;
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

        System.out.print("Enter Length of the array : ");
        int n1= scan.nextInt();
        int[] arr2=new int[n1];
        for (int i = 0; i < n1; i++) {
            arr2[i]= scan.nextInt();
        }
        System.out.println("Before Sorting : "+ Arrays.toString(arr2));
        optimizedSort(arr2);
        System.out.println("After Sorting : "+ Arrays.toString(arr2));

    }
}