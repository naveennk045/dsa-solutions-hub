package search;

public class BinarySearch {

    public static int find(int[] arr,int target){
        int left=0;
        int right=arr.length-1;

        while(left<=right){

            int mid=left+(right-left)/2;

            if(arr[mid] <target){
                left=mid+1;
            }
            else if (arr[mid]>target) {
                right=mid-1;
            }
            else{
                return mid;
            }

        }
        return arr[left];
    }
    public static void main(String[] args) {

        int[] nums={2,3,6,7,8,9,16,19,20};
        int target =15;
        System.out.println(find(nums,target));

    }
}