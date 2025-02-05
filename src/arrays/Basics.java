package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Basics {
    public static int[] moveZeros(int[] nums){
        int[] resArr=new int[nums.length];
        int start=0;
        int end=resArr.length-1;
        for(int num:nums){
            if(num!=0){
                resArr[start++]=num;
            }else{
                resArr[end--]=num;
            }
        }
        return resArr;
    }
    public static int[] productRemainingElements(int[] nums){
        int[] resArr=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product=1;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j]!=nums[i]){
                    product*=nums[j];
                }
            }
            resArr[i]=product;
        }
        return resArr;
    }
    public static int majorityElement(int[] nums){
        for(int i=0;i< nums.length;i++ ){
            int count=0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]==nums[j]) count++;
            }
            if(nums.length/2<count){
                return nums[i];
            }
        }
        return 0;
    }


    public static int sumOf(int[] nums){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return sum;
    }

    public static boolean binarySearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int mid=0;

        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            } else if (nums[mid]<target) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }

    public static void rightRotate(int[] nums,int n){
//        n-no of rotation
        n= nums.length%n;
        System.out.println(n);
        for (int i = 0; i <n; i++) {
            int lastElement=nums[nums.length-1];
            for (int j = nums.length-1; j >=1; j--) {
                nums[j]=nums[j-1];
            }
            nums[0]=lastElement;
            System.out.println(Arrays.toString(nums));

        }
    }

    public static void leftSum(int[] nums){
        int sum=sumOf(nums);
        for (int i = nums.length-1; i >=0; i--) {
            sum-=nums[i];
            nums[i]=sum;
        }
    }
    public static void rightSum(int[] nums){
        int sum=0;
        for (int i = nums.length-1; i >=0; i--) {
            int currElement=nums[i];
            nums[i]=sum;
            sum+=currElement;
        }
    }
//
//    public static int[] rightLeftSumDifference(int[] nums){
//        int[] rightSum=rightSum(nums);
//        int[] leftSum=
//    }




    public static void countEvenAndOdd(int[] nums){
        int oddCount=0;
        int evenCount=0;
        for(int num:nums) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }
        System.out.println("Odd number Count :"+ oddCount);
        System.out.println("Even number Count : "+evenCount);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Length of an array : ");
        int n= scan.nextInt();
        int [] nums=new int[n];
        for (int i=0;i< nums.length;i++){
            nums[i]= scan.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        countEvenAndOdd(nums);
        System.out.println("Majority Elements : "+majorityElement(nums));
        System.out.println(binarySearch(nums,5));
        System.out.println(sumOf(nums));
        System.out.println(Arrays.toString(moveZeros(nums)));
        System.out.println(Arrays.toString(productRemainingElements(nums)));
//        rightRotate(new int[] {1,2,3},11);
//        leftSum(nums);
//        System.out.println(Arrays.toString(nums));
        rightSum(nums);
        System.out.println(Arrays.toString(nums));

    }
}