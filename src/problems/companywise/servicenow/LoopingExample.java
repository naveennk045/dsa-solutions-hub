package problems.companywise.servicenow;

public class LoopingExample {
    public static void printNOddNumbers(int n){
        for (int i = 1; i <=n; i+=2) {
            System.out.print(i +" ");
        }
    }
    public static void printNEvenNumbers(int n){
        for (int i = 2; i <=n; i+=2) {
            System.out.print(i +" ");
        }
    }

    public static boolean isPrime(int number){
        if (number<=1) return false;
        for (int i = 2; i <=Math.sqrt(number); i++) {
            if(number%i==0) return false;
        }
        return true;
    }



    public static int factorial(int number){
        if(number<=1){
            return 1;
        }
        int factorial=1;
        while(number>0){
            factorial*=number;
            number--;
        }
        return factorial;
    }

    public static void main(String[] args) {
            printNOddNumbers(10);
            System.out.println();
            printNEvenNumbers(10);
            System.out.println();
            System.out.println(isPrime(43) ? "Prime":"Not prime");
            System.out.println(factorial(2));

    }
}