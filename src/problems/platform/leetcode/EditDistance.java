package problems.platform.leetcode;

public class EditDistance {
    public static int minDistance(String word1, String word2, int w1, int w2) {
        // base case
        if (w1 < 0) return w2 + 1;
        if (w2 < 0) return w1 + 1;

        // checking whether last two characters are matching or not
        if (word1.charAt(w1) == word2.charAt(w2)) {
            minDistance(word1, word2, w1 - 1, w2 - 1);
        }
        // three operations
        int replaceLength = minDistance(word1, word2, w1 - 1, w2 - 1);
        int deleteLength = minDistance(word1, word2, w1 - 1, w2);
        int insertLength = minDistance(word1, word2, w1, w2 - 1);

        System.out.println("replace : " + replaceLength);
        System.out.println("delete : " + deleteLength);
        System.out.println("insert : " + insertLength);
        System.out.println();

        return 1 + Math.min(replaceLength,
                Math.min(deleteLength, insertLength));

    }

    public static int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(minDistance(str1, str2));
    }
}