package problems.companywise.servicenow;

import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Amount : ");
        double amount=scan.nextInt();


        if(amount>=500.0){
            System.out.print("Do you have Membership? ");
            boolean isMember=scan.nextBoolean();
            if(isMember){
                System.out.println("DISCOUNT APPLIED..! you need to pay only $"+(amount-(amount*(0.5))));
            }
            else{
                System.out.println("DISCOUNT APPLIED..! you need to pay only $"+(amount-(amount*(0.2))));
            }
        }
        else{
            System.out.println("DISCOUNT NOT APPLIED..!");
        }
    }
}