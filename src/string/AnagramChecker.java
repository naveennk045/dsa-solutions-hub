package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);

        System.out.print("Enter Word1 : ");
        String word1=scan.next();

        System.out.print("Enter Word2 : ");
        String word2=scan.next();

        System.out.println(areAnagrams(word1,word2));

    }

    public static Boolean areAnagrams(String word1,String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) {
            return false;
        }


        HashMap<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) - 1);
        }

        for(Map.Entry<Character,Integer> entry : frequency.entrySet()){
            if (entry.getValue()>0){
                return false;
        }
    }
        return  true;
        }
}