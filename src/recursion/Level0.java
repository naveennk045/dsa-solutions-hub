package recursion;

public class Basics {
    public static boolean helper(int num ,int i){
        int pow=(int)Math.pow(2,i);
        if(i==Math.sqrt(num) && num!=pow) return false;
        if(pow == num ) return true;

        return helper(num,i+1);
    }

    public static int countZero(int num){
        return countZeroHelper(num,0);
    }

    public static int countZeroHelper(int num,int count){
        int digit=num%10;
        if(num==0) return count;
        if(digit==0) count++;

        return countZeroHelper(num/10,count);
    }
    public static void blast(int num){
        if(num<0) {
            System.out.print("Blast off....");
            return;
        }
        System.out.print(num+" ");
        blast(num-1);
    }
    //  approach 1
    public static void reverse(String word,int length,StringBuilder res){
        if(length==0){
            System.out.println(res);
            return;
        }
        length -= 1;
        char ch=(word.charAt(length));
        res.append(ch);
//        System.out.println(ch);
        reverse(word, length,res);

    }
    //    approach 2
    public static String reverse(String word,int pos){
        if(pos==0) return "";

        return word.charAt(pos-1)+reverse(word,pos-1);
    }

    public static void printNTo1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printNTo1(n - 1);
        System.out.print(n + " ");
    }

    public static void print1ToN(int n, int i) {
        if (i > n) {
            return;
        }
        System.out.print(i + " ");
        print1ToN(n, i + 1);
    }

    public static int sumN(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumN(n - 1);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static String reverseString(String s) {
        if (s.length() == 0) {
            return "";
        }
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int findMax(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.max(arr[n - 1], findMax(arr, n - 1));
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static int sumOfDigits(int n) {
        if(n==0){
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
    }

    public static void main(String[] args) {
        System.out.println("1. Print N to 1:");
        printNTo1(5);
        System.out.println("\n\n2. Print 1 to N:");
        print1ToN(5, 1);

        System.out.println("\n\n3. Sum of first N numbers: " + sumN(5));
        System.out.println("4. Factorial of N: " + factorial(5));

        System.out.println("\n5. Reverse of 'hello': " + reverseString("hello"));
        System.out.println("6. Palindrome check 'madam': " + isPalindrome("madam"));
        System.out.println("6. Palindrome check 'hello': " + isPalindrome("hello"));

        System.out.println("\n7. Fibonacci(5): " + fibonacci(5));

        int[] arr = {3, 1, 7, 8, 5};
        System.out.println("8. Max element in array: " + findMax(arr, arr.length));

        System.out.println("\n9. Power(2,3): " + power(2, 3));
        System.out.println("10. Sum of digits 1234: " + sumOfDigits(1234));

        blast(10);
        String word="java";
        StringBuilder res=new StringBuilder();
        reverse(word,word.length(),res);
        System.out.println(reverse(word,word.length()));

        System.out.println(countZero(300110));
        helper(16,0);
    }
}