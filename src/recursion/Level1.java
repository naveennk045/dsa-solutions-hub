package recursion;

public class Level1 {

    public static void printArrayElements(int[] nums, int i) {
        if (i == nums.length) return;
        System.out.print(nums[i] + " ");
        printArrayElements(nums, i + 1);
        System.out.print(nums[i] + " ");
    }

    public static void hailStone(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " --> ");

        if (n % 2 == 0) hailStone(n / 2);
        else hailStone(3 * n + 1);
    }

    public static String removeDuplicates(StringBuilder word, int i) {
        if (i == word.length() - 1) return word.toString();

        if (word.charAt(i) == word.charAt(i + 1)) {
            word.delete(i, i + 2);
            return removeDuplicates(word, 0);
        } else {
            return removeDuplicates(word, i + 1);
        }
    }

    public static void recursiveSequence(int num) {

    }

    public static String removeChars(String word, char target) {
        if (word.isEmpty()) return "";

        if (word.charAt(word.length() - 1) == target) {
            return removeChars(word.substring(0, word.length() - 1), target);
        } else {
            return removeChars(word.substring(0, word.length() - 1), target) + word.charAt(word.length() - 1);
        }
    }

    public static String removeWord(String word, String target) {
        if (word.isEmpty()) return "";

        if (word.startsWith(target)) {
            return removeWord(word.substring(target.length()), target);
        } else {
            return word.charAt(0) + removeWord(word.substring(1), target);
        }
    }

    public static void main(String[] args) {
//        int[] nums={1,2,3,4,5,6};
//        printArrayElements(nums,0);
//        System.out.println();
//        hailStone(6);
//        System.out.println();
        //        System.out.println(removeDuplicates(sb,0));

        System.out.println(removeChars("abdbaca", 'b'));

        System.out.println(removeWord("hiappleOrange", "apple"));

    }

}