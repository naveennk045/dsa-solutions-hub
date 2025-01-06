package search;

public class LinearSearch {

    public static int find(int[] nums,int target){
        int index =0;
        for(int num : nums){
            if(num==target){
                return index ;
            }
            index++;
        }
        return -1 ;
    }



    public static void main(String[] args) {
        int target=8;
        int[] nums={1,2,6,4,9,6,3};

        System.out.println(find(nums,target));
    }
}