package arrays;




public class MaxChunksToSortedArray {
    public static int maxChunksToSorted(int[] nums) {
        int currentMax = 0;
        int chunkCount = 0;


        for (int i = 0; i < nums.length; i++) {
            currentMax = Math.max(currentMax, nums[i]);

            if (i == currentMax) {
                chunkCount++;
            }
        }
        return chunkCount;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{5,6,9,2,8}));



    }
}