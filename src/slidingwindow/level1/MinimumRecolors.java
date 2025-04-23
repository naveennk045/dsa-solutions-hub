package slidingwindow.level1;



//https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
public class MinimumRecolors {
    public static int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int wCount=0;
        int bCount=0;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(blocks.charAt(i)=='W') wCount++;
            else bCount++;
           if(i>=k-1){
               min=Math.min(min,Math.min(bCount,wCount));
               if(blocks.charAt(i-k+1)=='W') wCount--;
               else bCount--;
           }
        }
        return min;
    }
    public static void main(String[] args) {
        String blocks="WBBWWBBWBW";
        System.out.println(minimumRecolors(blocks,7));
    }
}