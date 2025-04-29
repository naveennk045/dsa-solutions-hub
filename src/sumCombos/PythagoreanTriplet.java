package sumCombos;

import java.util.Arrays;
import java.util.HashSet;

public class PythagoreanTriplet {

    public static boolean pythagoreanTripletII(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int num : nums){
            set.add(num*num);
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int a=nums[i];
                int b=nums[j];

                int c=a*a + b*b;
//                System.out.println(c);
                if(c==(a*a + b*b ) && set.contains(c)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pythagoreanTripletI(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, left, right;

        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        for (int i = n - 1; i > 1; i--) {

            left = 0;
            right = i - 1;

            while (left < right) {
                if (nums[right] + nums[left] > nums[i]) {
                    right--;
                } else if (nums[right] + nums[left] < nums[i]) {
                    left++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};
//        if (pythagoreanTripletI(arr)) System.out.println("True");
//        else System.out.println("False");
        if (pythagoreanTripletII(arr)) System.out.println("True");
        else System.out.println("False");
    }

}