package patternPrinting;

public class NumberPatterns {
    public static void printNumbers(int n){

        int val=1;
        for (int i = 0; i <n ; i++) {
            val=(i==0) ? 1 : val+n-i+1;
//            System.out.print(val+" ");
            int temp=val;
            for (int j = 0; j <=i; j++) {

                System.out.print(temp+" ");
                temp=temp-(n-i+j);

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printNumbers(6);
    }
}