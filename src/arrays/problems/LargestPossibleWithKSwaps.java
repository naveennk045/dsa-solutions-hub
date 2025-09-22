package arrays.problems;

import java.util.Scanner;

public class LargestPossibleWithKSwaps {

    static class IndexMap {
        public char value;
        public int index;

        public IndexMap(char value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        scan.nextLine();
        char[] chars = scan.nextLine().toCharArray();


        IndexMap[] indexMaps = new IndexMap[chars.length];

        for (int i = 0; i < chars.length; i++) {
            indexMaps[i] = new IndexMap(chars[i], i);
        }


    }
}
