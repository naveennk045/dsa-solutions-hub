package arrays.problems;

public class Swap {

    public static void swap(int n1, int n2) {
        n1 = n1 + n2;
        n2 = n1 - n2;
        n1 = n1 - n2;


        System.out.println("After swapping : ");
        System.out.println("A : " + n1 + "  ||  B : " + n2);

    }

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 3;
        System.out.println("Before swapping : ");
        System.out.println("A : " + n1 + "  ||  B : " + n2);
        swap(5, 3);

    }
}