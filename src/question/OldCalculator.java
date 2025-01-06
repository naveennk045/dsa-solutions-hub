package ServiceNowQuestions;


abstract class Adder{
     abstract int add(int a, int b);
        }




 class Calculator extends Adder {

     public int add(int a, int b) {
         return a+b;
     }
     public int multiple(int a,int b){
         int sum=0;
         for (int i = 0; i < b; i++) {
             sum=add(sum,a);
         }
     return sum;}

 }
public class OldCalculator{
    public static void main(String[] args) {
        Calculator calc=new Calculator();
        System.out.println(calc.add(5,6));
        System.out.println(calc.multiple(5,6));
    }

}