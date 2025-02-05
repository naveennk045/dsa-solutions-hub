package servicenow.problem;

import java.util.Scanner;

public class AverageCalculator {

    public static float average(int[] marks){
        int total=0;
        for(int mark:marks){
            total+=mark;
        }
        return (float)total/(float) marks.length;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter Your Name : ");
        String name=scanner.nextLine();

        System.out.print("Enter Number of Subjects : ");
        int n= scanner.nextInt();

        int[] marks=new int[n];

        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter Subject "+(i+1)+ ":");
            marks[i]=scanner.nextInt();
        }

        System.out.println(average(marks));



    }
}