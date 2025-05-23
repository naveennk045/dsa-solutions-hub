package problems.platform.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/last-stone-weight/

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {

        if(stones.length<2) return 1;

        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            heap.add(stone);
        }

        while(heap.size()>=2){
            int fMax=heap.poll();
            int sMax=0;
            if(!heap.isEmpty()){
                sMax=heap.poll();
            }
            int val=fMax-sMax;
            heap.add(val);
        }



        return heap.element();
    }
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}