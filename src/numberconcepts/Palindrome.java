package numberconcepts;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome3(-121));

    }
//    Approach 1
    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int originalNum=x;
        int reversedNum=0;
        while(x!=0){
            int rem=x%10;
            reversedNum=reversedNum*10+rem;
            x=x/10;
        }

        return originalNum == reversedNum;
    }

//    Approach 2
    public static boolean isPalindrome2(int x){
        if ((x < 0) || ((x != 0) && ((x % 10) == 0))){
            return false;
        }
        int o=x;
        int r=0;
        while(x>r){
            r=r*10+(x%10);
            x=x/10;
        }
    return (x==r)||x==r/10;
    }
//Approach3
    public static boolean isPalindrome3(int x){
        String o=Integer.toString(x);
        StringBuilder r=new StringBuilder();
        for (int i = o.length()-1; i >=0; i--) {
            r.append(o.charAt(i));
        }
       return o.contentEquals(r);
    }

}