package combinatorics;

public class Permutation {
    public static void swap(char[] arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void permute(char[] word,int fi){

        if (fi==word.length-1){
            System.out.println(word);
            return;
        }
        for (int i = fi; i < word.length; i++) {
            swap(word,i,fi);
//            System.out.printf("fi : %d i : %d%n",fi,i);
            permute(word,fi+1);

            swap(word,i,fi);
        }

    }
    public static void main(String[] args) {
        permute(new char[]{'a','b','c'},0);
        System.out.printf("%05d",25);
    }
}