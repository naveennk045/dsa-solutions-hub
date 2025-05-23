package problems.companywise.microsoft.sumofcubes;

import java.util.Scanner;

public class SumOfCubes {
    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);

        System.out.print("Enter M : ");
        int m= scan.nextInt();

        System.out.print("Enter N : ");
        int n= scan.nextInt();

        if(m>n){
            System.out.println("Sum Of Cubes is , " +0);
        }
        else{
            int sum=0;
            for (int i = m; i <=n; i++) {
                sum+=i*i*i;
            }
            System.out.println("Sum Of Cubes is , " +sum);
        }

    }
}