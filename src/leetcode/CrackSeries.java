package leetcode;

//https://www.geeksforgeeks.org/problems/crack-the-series0304/1?page=1&company=Cognizant&sortBy=submissions

import java.math.BigInteger;

public class CrackSeries {
    public static BigInteger NthTerm(int N){
        if(N==1 || N==2) return BigInteger.valueOf(2);
        BigInteger num=BigInteger.valueOf(2);
        if(N%2!=0){
            for(int i=0;i<N/2;i++){
                num=num.pow(2);
//                System.out.println(num);
            }
            return num;
        }
        for(int i=0;i<N/2-1;i++){
            num=num.pow(3);
//            System.out.println(num);
        }
        return num;


    }
    public static void main(String[] args) {
        System.out.println(NthTerm(12));

    }
}