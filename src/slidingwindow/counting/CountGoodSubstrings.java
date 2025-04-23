package slidingwindow.counting;

import java.util.HashMap;

public class CountGoodSubstrings {
    public static int countGoodSubstringsII(String s)
    {
        int count = 0;
        for(int i=0 ; i <= s.length()-3 ; i++)
        {
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            char c = s.charAt(i+2);

            if( a!=b && b!=c && a!=c)
                count++;
        }
        return count;
    }

    public static int countGoodSubstringsI(String s) {

        HashMap<Character,Integer> charFrq = new HashMap<>();
        int k=3 , left=0 , n=s.length(),count=0;


        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            charFrq.put(ch,charFrq.getOrDefault(ch,0)+1);


            if(right>k-1) {
                charFrq.put(s.charAt(left), charFrq.getOrDefault(s.charAt(left), 0) - 1);
                if (charFrq.getOrDefault(s.charAt(left), 0) == 0) {
                    charFrq.remove(s.charAt(left));
                }
                left++;
            }

            if(charFrq.size()==3){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "aababcabc";

        System.out.println(countGoodSubstringsI(str));
        System.out.println(countGoodSubstringsII(str));
    }
}