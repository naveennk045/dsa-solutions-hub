package search;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

public class EvenDigits {

    public static int findNumbers(int[] nums) {
        int count=0;
        for(int num :nums){
            if(hasEvenDigits(num)){
                count++;
            }
        }
        return count;
    }

    public static boolean hasEvenDigits(int num){
        int count=0;
        while(num!=0){
            num/=10;
            count++;
        }
        return count%2==0;
    }

        public static void main(String[] args) {

        int[] nums={22,555,6666,32,875,2};
        System.out.println(findNumbers(nums));
    }
}