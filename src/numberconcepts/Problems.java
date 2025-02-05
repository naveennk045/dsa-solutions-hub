package numberconcepts;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;


public class Problems {

//    long have capacity to store only within 20 factorial
    public static long findFactorial(int num){
        if(num<=1){
            return 1;
        }
        long fact =1;
        for(int i=1;i<=num;i++){
            fact*=i;
        }
        return fact;
    }
//    So we are using the BigInteger;
    public static BigInteger findFactorial(long num){
        if(num<=1){
            return ONE;
        }
        BigInteger fact = ONE;
        for(int i=1;i<=num;i++){
            fact=fact.multiply(valueOf(i));
        }
        return fact;
    }

//    count trailing zeros
    public static long countTrailingZeros(BigInteger num){
        long count=0;
        while (num.mod(BigInteger.valueOf(10)).equals(BigInteger.ZERO)){
            num=num.divide(BigInteger.valueOf(10));
            count++;
        }
        return count;
    }
//    Count digits in a factorial using Logarithm
    public static long countDigits(long num){
        return (int)Math.log10(num)+1;
    }


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        long num1=findFactorial(num);
        System.out.println(num1);
        System.out.println("Length : "+countDigits(num1));
//        Using BigInteger
        BigInteger num2= findFactorial(10000l);
        System.out.println(num2.toString().length());
        System.out.println(countTrailingZeros(num2));

    }

}