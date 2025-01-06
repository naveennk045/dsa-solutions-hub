package string;

import java.util.Scanner;

public class SignalProcessing {


    public static String trim(String signal,int n){

        int i=0,j=n-1;

        while(i<j && signal.charAt(i)==signal.charAt(i+1)){
            i++;
        }
        while(i<j && signal.charAt(j)==signal.charAt(j-1)){
            j--;
        }

        return signal.substring(i,j);

    }

    public static int maximumSignal(String signal){
        int count=1;
        int maximumCount=Integer.MIN_VALUE;
        for (int i = 1; i < signal.length(); i++) {
            if(signal.charAt(i)==signal.charAt(i-1)){
                count++;
            }
            else{
                maximumCount=Math.max(count,maximumCount);
                count=1;
            }
        }
        maximumCount=Math.max(count,maximumCount);
        return maximumCount;
    }



    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.print("Enter number of signal : ");
        int n= scan.nextInt();

        System.out.print("Enter signal : ");
        String word=scan.next();

        String trimmedString=trim(word,n);
        int count=maximumSignal(trimmedString);

        System.out.println(count);

    }
}