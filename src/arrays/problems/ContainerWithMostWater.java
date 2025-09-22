package arrays.problems;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));

    }
    public static int maxArea(int[] height) {
        int s=0,e= height.length-1;
        int sum=0;
        while(s<e){
            if(height[s]>height[e]){
                for (int i = s; i < e+1 ; i++) {
                    sum+=height[i];
                    break;
                }
           }
       s++; }

   return sum; }
}