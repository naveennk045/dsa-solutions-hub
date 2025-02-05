package numberconcepts;

import java.util.HashSet;
import java.util.Scanner;

public class SpecialNumber {
    public static int sumOfSquareDigits(int num){
        int sum=0;
        while(num>0){
            int currDigit=num%10;
            sum+=currDigit*currDigit;
            num/=10;
        }
        return sum;
    }
    public static boolean isHappyNumber(int num){
        HashSet<Integer> set=new HashSet<>();
        while(num!=1){
            if(set.contains(num)){
                return false;
            }
            set.add(num);
            num=sumOfSquareDigits(num);
        }
        return true;
    }
    public static long factorial(int num){
        if(num<=1){
            return 1;
        }
        long fact =1;
        for(int i=1;i<=num;i++){
            fact*=i;
        }
        return fact;
    }
    public static boolean isKrishnamurtiNumber(int num){
        int originalNum=num;
        int sum=0;
        while(num!=0){
            sum+=factorial(num%10);
            num/=10;
        }
        return originalNum==sum;
    }
        public static boolean isPerfectNumber(int num){
            long sum=0;
            for (int i = 1; i < num; i++) {
                if(num%i==0){
                    sum+= i;
                    System.out.println(sum);
                }
            }
            return num==sum;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        if (isHappyNumber(num)) {
            System.out.println(num + " is a Happy Number.");
        } else {
            System.out.println(num + " is NOT a Happy Number.");
        }
        if (isKrishnamurtiNumber(num)) {
            System.out.println(num + " is a Krishnamurti Number.");
        } else {
            System.out.println(num + " is NOT a Krishnamurti  Number.");
        }
        if (isPerfectNumber(num)) {
            System.out.println(num + " is a perfect Number.");
        } else {
            System.out.println(num + " is NOT a perfect Number.");
        }
    }
}