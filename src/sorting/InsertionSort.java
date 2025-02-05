package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void sort(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int key=arr[i];
            int j=i-1;
//            System.out.printf("i : %d , key : %d ,j : %d ",i,key,j);
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
            System.out.println(Arrays.toString(arr));
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