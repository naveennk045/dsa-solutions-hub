package recursion;

import java.util.ArrayList;

public class ProblemsOnString {
    public static boolean isPalindrome(String word){
        int left=0,right=word.length()-1;

        while(left<right){
            if(word.charAt(right)!=word.charAt(left)) return false;
            right--;
            left++;
        }
        return true;
    }

    public static ArrayList<String> allPalindromicPerms(String S,String P) {
        if(S.isEmpty()) {

            ArrayList<String> list = new ArrayList<>();
            if (isPalindrome(P)) {
                list.add(P);
            }
            return list;
        }
        ArrayList<String> left= allPalindromicPerms(S.substring(1),P+S.charAt(0));
        ArrayList<String> right= allPalindromicPerms(S.substring(1),P);

        left.addAll(right);

        return left;
    }

//    public static ArrayList<>
    public static void main(String[] args) {
        ArrayList<String> list=allPalindromicPerms("nitin","");

        System.out.println(list);
    }
}