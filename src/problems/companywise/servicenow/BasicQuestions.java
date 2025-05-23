package problems.companywise.servicenow;

public class BasicQuestions {

    //  Find the sum of two numbers
    public static int sumOfTwoNumbers(int a, int b) {
        return a + b;
    }

    // Find the largest of three numbers
    public static int largestOfThree(int a, int b, int c) {
        //   return Math.max(a, Math.max(b, c));  Built-in Function
        if(a>b && a>c) return a;
        else if (c>b && c>a) return c;
        else return b;
    }

    //  Calculate the sum of numbers from 1 to n
    public static int sumUpToNNumbers(int n) {
//        return (n*(n+1))/2; with formula
        int sum=0;
        for (int i = 0; i <=n ; i++) {
            sum+=i;
        }
        return sum;
    }

    // Print multiplication table for a number
    public static void printMultiplicationTable(int number){
        for (int i = 0; i <=10 ; i++) {
            System.out.println(i +" × "+number+" = " +(number*i));
        }
    }

    //  Count the number of digits in a number
    public static int  countDigit(int number){
//        return String.valueOf(number).length();
        int count=0;
        while(number!=0){
            number/=10;
            count++;
        }
        return count;
    }

    //  Reverse a number
    public static int reverseNumber(int number){
//        return Integer.valueOf(new StringBuilder(String.valueOf(number)).reverse().toString());
        int reversedNum=0;
        while (number!=0){
            int currNum=number%10;
            reversedNum=reversedNum*10+currNum;
            number/=10;
        }
        return reversedNum;
    }

    //  Reverse a String
    public static String reverseString(String word ){
//        return new StringBuilder(word).reverse().toString();
        StringBuilder sb=new StringBuilder(word);
        int start=0,end=word.length()-1;
        while(start<end){
            char temp=sb.charAt(end);
            sb.setCharAt(end,sb.charAt(start));
            sb.setCharAt(start,temp);
            start++;
            end--;
        }
        return sb.toString();
    }





        // Check if a number is even or odd
    public static String isEvenOrOdd(int number){
        return (number%2==0)?"Even":"Odd";
    }

    //  Check if a number is prime
    public static boolean isPrime(int number){
        if(number<=1) return false;
        for (int i = 2; i <=Math.sqrt(number) ; i++) {
            if (number%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(sumOfTwoNumbers(5,9));
        System.out.println(largestOfThree(8,9,4));
        System.out.println(sumUpToNNumbers(5));
        System.out.println(isEvenOrOdd(5));
        System.out.println(isPrime(6));
        printMultiplicationTable(2);
        System.out.println(countDigit(5687554));
        System.out.println(reverseNumber(123));
        System.out.println(reverseString("NKNK"));
    }
}