package numberconcepts;

import java.util.HashMap;
import java.util.Scanner;

public class DigitManipulation {
    public static int largestDigit(int num){
        int max=0;
        while(num>0){
            if(num %10 > max) max=num%10 ;
            num/=10;
        }
        return max;
    }
    public static int reverseNum(int num){
        int reversedNum=0;
        while(num!=0){
            int currNum=num%10;
            reversedNum=reversedNum*10+currNum;
            num/=10;
        }
        return reversedNum;
    }

    public static boolean isMerciNumber(int num){
        int i=(int)Math.sqrt(num);
        while((i*i)<=num+1) {
            int merciNumber = (int) (Math.pow(2, i) - 1);
            System.out.print(merciNumber+" ");
            if (merciNumber == num) {
                return true;
            }
            i++;
        }
       return false;
    }
    public static void printDigitFromLeftToRight(int num){
        int divisor=(int)Math.pow(10,(int) Math.log10(num));
        while(num!=0){
            int currNum=num/divisor;
            System.out.println(currNum);
            num-=currNum*divisor;
            divisor/=10;
        }

    }
    public static boolean isHarshadNumber(int num){
        int sum=sumOfDigits(num);
        return num % sum == 0;
    }
    public static int sumOfDigits(int num){
        int sum=0;
        while(num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public static int countNoOfDigits(int num){
        return (int)Math.log10(num)+1;

//        int count=0;
//        while(num!=0){
//            num/=10;
//            count++;
//        }
//        return count;
    }
    public static boolean isArmstrong(int num){
        int sum=0;
        int originalNum=num;
        while(num>0){
            int currDigit=num%10;
            sum+=Math.pow(currDigit,countNoOfDigits(originalNum));
            num/=10;
        }
        return originalNum==sum;
    }

    public static void printFrequencyOfDigits(int num){
        for(int i=9;i>=0;i--){
            int tempNum=num;
            int count=0;
            while(tempNum>0){
                if(tempNum%10 == i){
                    count++;
                }
                tempNum/=10;
            }
            if(count!=0){
                System.out.println(i+" : "+count);
            }
        }

    }

    public static boolean isPalindrome(int num){
        return reverseNum(num)==num;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Sum of digit : " +sumOfDigits(1234));
        printDigitFromLeftToRight(123456789);
        System.out.println("Count : " +countNoOfDigits(1234));
        System.out.println("Reversed Num : "+reverseNum(123));
        System.out.println(isHarshadNumber(13));
        System.out.println(isPalindrome(1234321));
        System.out.println(largestDigit(14345));
        System.out.println(isArmstrong(1634));
        printFrequencyOfDigits(123);

        System.out.println(isMerciNumber(15));

    }
}