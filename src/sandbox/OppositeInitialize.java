package sandbox;

public class OppositeInitialize {
    public static void main(String[] args) {
        int[] nums={1,2,3,5,6};
        int left=0;
        int right=nums.length-1;
        int sum=0;
        int target=8;
        for(int num : nums){
            sum+=num;
        }
        if(sum==target){
            System.out.println("Left : "+left +" Right : "+right);
        }

        while(left<right){
            sum-=nums[left++];
            if(sum==target){
                System.out.println("Left : "+left +" Right : "+right);
            }
            sum-= nums[right--];
            if(sum==target){
                System.out.println("Left : "+left +" Right : "+right);
            }
        }
    }
}