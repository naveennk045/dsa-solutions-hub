package patquestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumTimeForCandies{

//    Brute Force approach : O(n*nlogn)

    public static int methodI(int[] nums){
        Arrays.sort(nums);

        int previous=nums[0];
        int total=0;
        for(int i=1;i<nums.length;i++){
            previous+=nums[i];
            total+=previous;
        }
        return total;
    }
// Optimal using priority queue : O(nlogn)
    public  static int methodII(int[] nums) {
        PriorityQueue<Integer> queue =new PriorityQueue<>();

        for(int num : nums){
            queue.add(num);
        }
        int total=0;

        while(queue.size()>1){
            int  first= queue.poll();
            int  second= queue.poll();
            System.out.println(queue);
            int merged=first+second;
            total+=merged;
            queue.add(merged);



        }


        return total;
    }
    public static void main(String[] args) {

        int[] nums = {2, 3, 6};
        System.out.println(methodII(nums));
    }
}