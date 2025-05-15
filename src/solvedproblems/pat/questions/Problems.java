package solvedproblems.pat.questions;

import java.util.Scanner;

public class Problems {

    static Scanner scan=new Scanner(System.in);

    public static boolean isPrime(int num){
        if(num<2) return false;

        for (int i = 2; i <=Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }

    public static void goldbachPairs(){
        int start=scan.nextInt();
        int end= scan.nextInt();

        if(start%2!=0){
            start+=1;
        }

        for(int i=start;i<end+1;i+=2){
            for(int j=2;j<=i/2;j++){
                if(isPrime(j)){
                    int k=i-j;
                    if(isPrime(k)){
                        System.out.printf("%d = %d + %d%n",i,k,j);
                        break;
                    }
                }
            }
        }
    }

    public static void automobileCompany(){

        int V=scan.nextInt();
        int W= scan.nextInt();

        if(W%2!=0 || V>W) {
            System.out.println("Invalid Input");
            return;
        }

        int FW=-((2*V-W)/2);
        int TW=V-FW;
        System.out.println("FOUR WHEELER : "+FW);
        System.out.println("TWO WHEELER : "+TW);
    }

    public static void minimumCost(){
        int n=scan.nextInt();

//        Shop-1
        int m1=scan.nextInt();
        int p1= scan.nextInt();
//        Shop-2
        int m2=scan.nextInt();
        int p2= scan.nextInt();

        int minCost=Integer.MAX_VALUE;
        int range=n/m1;
        System.out.println("Range : "+range);
        for(int i=0;i<range+1;i++){
            int remaining=n-(i*m1);
            System.out.println("Remaining : "+remaining);
            if(remaining%m2==0){
                minCost=Math.min(minCost,(i*p1+(remaining/m2)*p2));
                System.out.println("MinCost : "+minCost);
            }
        }
        System.out.println(minCost);
    }
    public static void main(String[] args) {
        minimumCost();
//        automobileCompany();
//        goldbachPairs();
    }
}