package arrays.problems;


public class LongestSubsequence {
    public static void main(String[] args) {
        int[] array={10,9,2,5,3,7,101,18};


        int count=1;
        int j=1;
        for (int k : array) {
            if (k < array[j]) {
                count++;
                j++;
            }


        }
        System.out.println(count);
    }
}