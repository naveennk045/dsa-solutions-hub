package recursion;

public class ReverseString {
    public static String reverse(String str, int idx) {
        if (idx == str.length()) return "";

        return reverse(str, idx + 1) + str.charAt(idx);
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcd", 0));
    }
}