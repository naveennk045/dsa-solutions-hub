package GeeksForGeeks;

import java.util.Scanner;

//https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1?page=1&sortBy=submissions
public class MinimumJumps {
    public static int minJumps(int[] steps) {
        if(steps[0]==0) return -1;

        int lastPos=steps.length-1;
        int count=0;
        for(int i=0;i<lastPos;){
            int step=steps[i];
            if(step==0){
                return -1;
            }
            else {
                i+=step;
                count++;
            }
            if(i>=lastPos) return count;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        int[] nums=new int[size];

        for(int i=0;i<size;i++){
            nums[i]= scan.nextInt();
        }
        int jumps=minJumps(nums);
        System.out.println(jumps);
    }
}