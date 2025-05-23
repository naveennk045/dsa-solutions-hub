package problems.companywise.servicenow;

import java.util.Scanner;

public class Test {
    static Scanner scan=new Scanner(System.in);

    public static void problemOne(){
        System.out.print("Enter Number : ");
        int num= scan.nextInt();
        int max=num;
        int min=num;
        while(true){
            System.out.print("Do you want to Continue? (y/n) : ");

            if(scan.next().charAt(0) == 'n')
                break;

            System.out.print("Enter Number : ");
            num= scan.nextInt();
           if(num>max)
               max=num;
           if(num<min)
               min=num;
        }

        System.out.println("Largest Number : "+ max);
        System.out.println("Smallest Number : "+min);
    }
    public static void main(String[] args) {
            problemOne();
    }
}