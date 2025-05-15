package solvedproblems.pat.questions;

public class PrintPyramidLogicNumbers {

    public static void main(String[] args) {
        int n=3;
        int k=2;
        int ind=0;

        while(ind<n){
            int col=0;
            while(col<=ind){
                int num= k*((2*k)-1);
                System.out.printf("%05d ",num);
                col++;
                k+=2;
            }
            ind++;
            System.out.println();

        }
    }
}