package solvedproblems.platform.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/fair-candy-swap/description/?envType=problem-list-v2&envId=26tnx5om
public class FairCandySwap {

//    BruteForce approach
    public static int[] fairCandySwapI(int[] aliceSizes, int[] bobSizes) {
        int[] result=new int[2];

        int aSum=0;
        int bSum=0;

        for(int aliceSize : aliceSizes){
            aSum+=aliceSize;
        }
        for (int bobSize : bobSizes){
            bSum+=bobSize;
        }

        for(int aliceSize : aliceSizes){
            for(int bobSize : bobSizes){
                int aVal=aSum-aliceSize+bobSize;
                int bVal=bSum-bobSize+aliceSize;
                if(aVal==bVal){
                    result[0]=aliceSize;
                    result[1]=bobSize;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] aliceSizes={1,2,3,4};
        int[] bobSizes={9,6,8};

        int[] result=fairCandySwapI(aliceSizes,bobSizes);
        System.out.println(Arrays.toString(result));
    }
}