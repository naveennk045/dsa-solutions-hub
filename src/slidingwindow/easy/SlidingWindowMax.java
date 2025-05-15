package slidingwindow.easy;

import java.util.*;

//https://leetcode.com/problems/sliding-window-maximum/description/

public class SlidingWindowMax {
    public static int[] maxSlidingWindowIII(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[n - k + 1];

        int left = 0, right = 0;  // Added left and right pointers

        while (right < n) {
            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);


            // Remove elements out of the window (only when window size > k)
            if (!deque.isEmpty() && !(deque.peekFirst() >= left && deque.peekFirst() <= right)) {
                deque.pollFirst();
            }

            // If window has at least k elements, record the max
            if (!deque.isEmpty() && right -left + 1 == k) {
                result[left] = nums[deque.peekFirst()];
                left++;  // Move window ahead
            }


            right++;
        }

        return result;
    }

//    Using a sliding window + heap
    public static int[] maxSlidingWindowII(int[] nums, int k) {
        int size=nums.length;
        int left=0,right=0;

        int[] maxNums=new int[size+1-k];

        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());

        for(;right<k;right++){
            heap.add(nums[right]);
        }
        maxNums[left]=heap.element();

        while(right<size){
//            System.out.printf("left : %d -  right : %d%n",left,right);
            heap.add(nums[right++]);
            heap.remove(nums[left++]);
            maxNums[left]=heap.element();
//            System.out.println(heap);
        }
        return maxNums;
    }



    public static int max(int[] nums,int start,int end){
        int max=nums[start];
        int maxIdx=start;

        for(;start<=end;start++){
            if(max<nums[start]){
                max=nums[start];
                maxIdx=start;
            }
//            max=Math.max(max,nums[start]);
        }
        return maxIdx;
    }
    public static int[] maxSlidingWindowI(int[] nums, int k) {
        int size=nums.length;
        int[] maxNums=new int[size+1-k];

//        Initial window
        int left=0,right=k-1;
         int prevMaxIdx=max(nums,left,right);
         maxNums[left]=nums[prevMaxIdx];
         left++;
         right++;



        while(right<size){

            if(prevMaxIdx>=left && prevMaxIdx<=right){
                if(nums[right]>nums[prevMaxIdx]){
                    prevMaxIdx=right;
                    maxNums[left]=nums[right];
                }else{
                    maxNums[left]=nums[prevMaxIdx];
                }
            }
            else{
                prevMaxIdx=max(nums,left,right);
                maxNums[left]=nums[prevMaxIdx];
            }
            left++;
            right++;
        }
        return maxNums;
    }
    public static void main(String[] args) {

        int[] nums={-7,-8,7,5,7,1,6,0};
        int[] result1=maxSlidingWindowI(nums,4);
        System.out.println(" Using Sliding window: "+Arrays.toString(result1));
        int[] result2=maxSlidingWindowII(nums,4);
        System.out.println(" Using Sliding window + Max heap: "+Arrays.toString(result2));
        int[] result3=maxSlidingWindowIII(nums,4);
        System.out.println(" Using Sliding window + Dequeue : "+Arrays.toString(result3));
    }


}