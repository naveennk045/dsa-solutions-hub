package dynamicprogramming;

public class InterleavingStrings {

    public static boolean isInterleave(String s1, String s2, String s3) {
        return generatePermutation(s1 + s2, s3, "", new boolean[s1.length() + s2.length()]);
    }

    public static boolean generatePermutation(String str, String target, String currPermutation, boolean[] used) {
        if (currPermutation.length() == target.length()) {
            System.out.println(currPermutation);
            return currPermutation.equals(target);
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            if (generatePermutation(str, target, currPermutation + str.charAt(i), used)) return true;
            used[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
